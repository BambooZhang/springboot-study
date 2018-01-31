package com.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * rabbitMq工具类
 * <p>rabbitMq工具类
 *
 * @version V1.0   
 * @Class: RabbitUtils
 * @Package com.test
 * @Created bamboo  zjcjava@163.com
 * @Date 2018-01-04 23:46
 */
public class RabbitUtils {
    static  Channel channel;
    static  Connection connection;

    public static  Channel init() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.0.80");
        factory.setUsername("root");
        factory.setPassword("root");
        factory.setPort(5672);
        connection = factory.newConnection();
        channel = connection.createChannel();

        return channel;
    }


    public static void close() throws Exception {
        channel.close();
        connection.close();
    }
}
