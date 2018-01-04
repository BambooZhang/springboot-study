package com.bamboo;



import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 消息生产者
 * <p>消息生产者
 *
 * @version V1.0   
 * @Class: Sender
 * @Package com.bamboo
 * @Created bamboo  zjcjava@163.com
 * @Date 2018-01-03 15:24
 */
//@Component
public class Sender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String msg) {
        this.rabbitTemplate.convertAndSend("foo", msg);
    }

}
