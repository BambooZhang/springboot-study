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
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.rabbitmq.client.Channel;
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

    /** 设置交换机类型  */
    @Bean
    public DirectExchange defaultExchange() {
        /**
         * DirectExchange:按照routingkey分发到指定队列
         * TopicExchange:多关键字匹配
         * FanoutExchange: 将消息分发到所有的绑定队列，无routingkey的概念
         * HeadersExchange ：通过添加属性key-value匹配
         */
        return new DirectExchange(AmqpConfig.FOO_EXCHANGE);
    }

    @Bean
    public Queue fooQueue() {
        return new Queue(AmqpConfig.FOO_QUEUE);
    }

    @Bean
    public Binding binding() {
        /** 将队列绑定到交换机 */
        return BindingBuilder.bind(fooQueue()).to(defaultExchange()).with(AmqpConfig.FOO_ROUTINGKEY);
    }

    @RabbitHandler
    public void process(@Payload String foo) {
        LOGGER.info("CallListener: " + foo);
    }


/*    @Bean
    public SimpleMessageListenerContainer messageContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(AmqpConfig().connectionFactory());
        container.setQueues(fooQueue());
        container.setExposeListenerChannel(true);
        container.setMaxConcurrentConsumers(1);
        container.setConcurrentConsumers(1);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); //设置确认模式手工确认
        container.setMessageListener(new ChannelAwareMessageListener() {

            @Override
            public void onMessage(Message message, Channel channel) throws Exception {
                byte[] body = message.getBody();
                LOGGER.info("Listener onMessage : " + new String(body));
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false); //确认消息成功消费
            }
        });
        return container;
    }*/
}
