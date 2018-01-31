package com.callback;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;

/**
 * 消息监听器
 * <p>消息监听器
 *
 * @version V1.0   
 * @Class: TransactionConsumeImpl
 * @Package com.callback
 * @Created bamboo  zjcjava@163.com
 * @Date 2018-01-05 17:35
 */
@Component
public class TransactionConsumeImpl implements ChannelAwareMessageListener {
    private static final Logger logger = LoggerFactory.getLogger(TransactionConsumeImpl.class);


    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        String boby = new String(message.getBody(), "utf-8");//转换消息，我们是使用json数据格式


                logger.info("客户交易流水添加1条记录:{}", boby);


                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);//手工返回ACK，通知此消息已经争取消费


    }
}
