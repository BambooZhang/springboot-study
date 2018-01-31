package com.rabbitmq.topic;



import com.rabbitmq.client.*;
import com.rabbitmq.RabbitUtils;

import java.io.IOException;

/**
 * 消息接收：订阅匹配模式消息
 * <p>消息接收：订阅消息
 *
 * @version V1.0   
 * @Class: ReceiveLogsTopic1
 * @Package com.test.topic
 * @Created bamboo  zjcjava@163.com
 * @Date 2018-01-04 23:38
 */
public class ReceiveLogsTopic {


    private static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] argv) throws Exception {

        Channel channel= RabbitUtils.init();


//      声明一个匹配模式的交换器
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");
        String queueName = channel.queueDeclare().getQueue();
        // 路由关键字
        //String[] routingKeys = new String[]{"*.orange.*"};
        String[] routingKeys = new String[]{"*.*.rabbit", "lazy.#"};//多个匹配
//      绑定路由关键字
        for (String bindingKey : routingKeys) {
            channel.queueBind(queueName, EXCHANGE_NAME, bindingKey);
            System.out.println("ReceiveLogsTopic1 exchange:"+EXCHANGE_NAME+", queue:"+queueName+", BindRoutingKey:" + bindingKey);
        }

        System.out.println("ReceiveLogsTopic1 [*] Waiting for messages. To exit press CTRL+C");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println("ReceiveLogsTopic1 [x] Received '" + envelope.getRoutingKey() + "':'" + message + "'");
            }
        };
        channel.basicConsume(queueName, true, consumer);
    }
}
