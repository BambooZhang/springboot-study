package com.rabbitmq.queues;




import com.rabbitmq.RabbitUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
/**
 * 发布任务
 * <p>发布任务
 * 消息持久化
 * 消息的可靠性是RabbitMQ的一大特色，那么RabbitMQ是如何保证消息可靠性的呢——消息持久化。
 为了保证RabbitMQ在退出或者crash等异常情况下数据没有丢失，需要将queue，exchange和Message都持久化。
 同时消费方autoAck设置为false，然后在正确处理完消息之后进行手动ack
 1.exchange的持久化,声明转发器的类型
 *2.queue持久化
 * 3.生产者消息持久化
 * 4.进行手动确认：消息消费完成确认
 *
 * @version V1.0   
 * @Class: Task
 * @Package com.rabbitmq.queues
 * @Created bamboo  zjcjava@163.com
 * @Date 2018-01-05 0:05
 */

public class Task {


    private static final String EXCHANGE_NAME = "task_exchange";
    private static final String TASK_QUEUE_NAME = "task_queue";

    public static void main(String[] argv) throws java.io.IOException, Exception {

        Channel channel=RabbitUtils.init();

        //1.exchange的持久化,声明转发器的类型
        channel.exchangeDeclare(EXCHANGE_NAME, "direct",true);
        //2.queue的持久化,(已经定义的队列，再次定义是无效的)
        channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);
        // 分发消息
        for(int i = 0 ; i < 5; i++){
            String message = "Hello World! " + i;
            //3.消息持久化,PERSISTENT_TEXT_PLAIN
            channel.basicPublish("", TASK_QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        }


        RabbitUtils.close();
    }
}
