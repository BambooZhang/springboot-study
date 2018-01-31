package com.callback;




import com.callback.config.AmqpConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 消息生产者
 * <p>消息生产者
 *
 * @version V1.0   
 * @Class: Sender
 * @Package com.callback
 * @Created bamboo  zjcjava@163.com
 * @Date 2018-01-03 20:47
 */
@Component
public class Sender implements RabbitTemplate.ConfirmCallback {

    private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public Sender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        this.rabbitTemplate.setConfirmCallback(this); //rabbitTemplate如果为单例的话，那回调就是最后设置的内容
    }

    //如果是一个objct对象最好转成j'son字符串处理
    public void send(String msg) {
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        LOGGER.info("send: " + correlationData.getId());
        this.rabbitTemplate.convertAndSend(AmqpConfig.FOO_EXCHANGE, AmqpConfig.FOO_ROUTINGKEY, msg, correlationData);
    }

    /** 回调方法 */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        LOGGER.info("回调id: " + correlationData.getId());
        if (ack) {
            LOGGER.info("生产者回调-消息成功消费");
        } else {
            LOGGER.info("生产者回调-消息消费失败:" + cause);
        }
    }
}