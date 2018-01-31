package com.callback;


import com.callback.config.AmqpConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.rabbitmq.client.Channel;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;


/**
 * 消息监听者
 * <p>消息监听者
 *
 * @version V1.0   
 * @Class: Listener
 * @Package com.callback
 * @Created bamboo  zjcjava@163.com
 * @Date 2018-01-03 20:48
 */
@Configuration
@RabbitListener(queues = AmqpConfig.FOO_QUEUE)
public class Listener {

    private static final Logger LOGGER = LoggerFactory.getLogger(Listener.class);

    /** 设置交换机类型
     * DirectExchange:按照routingkey分发到指定队列
     * TopicExchange:多关键字匹配
     * FanoutExchange: 将消息分发到所有的绑定队列，无routingkey的概念
     * HeadersExchange ：通过添加属性key-value匹配
     */
    @Bean
    public DirectExchange defaultExchange() {

        return new DirectExchange(AmqpConfig.FOO_EXCHANGE);
    }

    //队列持久
    @Bean
    public Queue fooQueue() {
        return new Queue(AmqpConfig.FOO_QUEUE, true); //队列持久
    }


    //将队列绑定到交换机
    @Bean
    public Binding binding() {

        return BindingBuilder.bind(fooQueue()).to(defaultExchange()).with(AmqpConfig.FOO_ROUTINGKEY);
    }

    //消息处理：如果要处理的是objct类型对象则字符串为json格式，自行转换为objcet
    @RabbitHandler
    public void process(@Payload String msg, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, Channel channel) throws Exception{


        LOGGER.info("处理并确认消息"+deliveryTag+" receiver message: " + msg);
        //TODO 写自己的业务逻辑代码


    }


}
