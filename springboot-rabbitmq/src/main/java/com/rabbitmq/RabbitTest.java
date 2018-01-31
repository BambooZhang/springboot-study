package com.rabbitmq;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.UUID;


/**
 *客户端链接测试
 *
 * @version V1.0   
 * @Class: Sender
 * @Package com.bamboo
 * @Created bamboo  zjcjava@163.com
 * @Date 2018-01-03 15:24
 */
public class RabbitTest {

    private final static String QUEUE_NAME = "hello";

    private static final String EXCHANGE_NAME = "topic_logs";


    public static void  hello(Channel channel)throws Exception {
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "Hello World!";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");
    }

    public static void topic(Channel channel) throws Exception {

        // 声明转发器
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");
        //定义绑定键
        String[] routing_keys = new String[] { "quick.orange.rabbit",
                "lazy.orange.elephant",
                "quick.orange.fox",
                "lazy.brown.fox",
                "quick.brown.fox",
                "quick.orange.male.rabbit",
                "lazy.orange.male.rabbit" };
        for (String routing_key : routing_keys)
        {
            //发送不同绑定键的消息
            String msg = UUID.randomUUID().toString();
            channel.basicPublish(EXCHANGE_NAME, routing_key, null, msg
                    .getBytes());
            System.out.println(" [x] Sent routingKey = "+routing_key+" ,msg = " + msg + ".");
        }


    }

    public static void main(String[] argv) throws Exception {
        Channel channel=RabbitUtils.init();
        topic(channel);
        RabbitUtils.close();
    }
}
