package com.rabbitmq.queues;

import com.rabbitmq.RabbitUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * 任务消费者2
 * <p>任务消费者2
 *
 * 1.exchange的持久化,声明转发器的类型
 *2.queue持久化
 * 3.生产者消息持久化
 * 4.进行手动确认：消息消费完成确认
 * @version V1.0   
 * @Class: Worker1
 * @Package com.rabbitmq.queues
 * @Created bamboo  zjcjava@163.com
 * @Date 2018-01-05 0:08
 */
public class Worker2 {


    private static final String EXCHANGE_NAME = "task_exchange";
    private static final String TASK_QUEUE_NAME = "task_queue";

    public static void main(String[] argv) throws Exception {
        final   Channel channel= RabbitUtils.init();

        //1.exchange的持久化,声明转发器的类型
        channel.exchangeDeclare(EXCHANGE_NAME, "direct",true);
        //2.queue持久化
        channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);
        System.out.println("Worker2 [*] Waiting for messages. To exit press CTRL+C");
        //负载均衡:每次从队列中获取数量:当消费者处理完成当前消息并反馈后，才会收到另外一条消息或任务
        channel.basicQos(1);

        final Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");

                System.out.println("Worker2 [x] Received '" + message + "'");
                try {
                    //处理任务
                    doWork(message);
                } finally {
                    System.out.println("Worker2 [x] Done");
                    // 消息处理完成确认
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
            }
        };
        //4.进行手动确认：消息消费完成确认
        channel.basicConsume(TASK_QUEUE_NAME, false, consumer);
    }

    private static void doWork(String task) {
        try {
            Thread.sleep(1000); // 暂停1秒钟
        } catch (InterruptedException _ignored) {
            Thread.currentThread().interrupt();
        }
    }

}
