package com.callback.config;




import com.callback.Listener;
import com.callback.TransactionConsumeImpl;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * mq配置文件:手工配置
 * <p>mq配置文件
 *
 * @version V1.0
 * @Class: AmqpConfig
 * @Package com.callback.config
 * @Created bamboo  zjcjava@163.com
 * @Date 2018-01-03 20:45
 */
@Configuration
public class AmqpConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(AmqpConfig.class);

    public static final String FOO_EXCHANGE   = "callback.exchange.foo1";
    public static final String FOO_ROUTINGKEY = "callback.routingkey.foo1";
    public static final String FOO_QUEUE      = "callback.queue.foo1";

    @Value("${spring.rabbitmq.addresses}")
    private String addresses;
    @Value("${spring.rabbitmq.username}")
    private String username;
    @Value("${spring.rabbitmq.password}")
    private String password;
    @Value("${spring.rabbitmq.virtual-host}")
    private String virtualHost;
    @Value("${spring.rabbitmq.publisher-confirms}")
    private boolean publisherConfirms;

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses(addresses);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost(virtualHost);
        /** 如果要进行消息回调，则这里必须要设置为true */
        connectionFactory.setPublisherConfirms(publisherConfirms);
        System.out.println("初始化路由>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.");
        return connectionFactory;
    }

    @Bean
    /** 因为要设置回调类，所以应是prototype类型，如果是singleton类型，则回调类为最后一次设置 */
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        return template;
    }




    /*****************************下面的部分则直接把消费端的内容写在这里，使用messageContainer 替换@RabbitHandler 注解中的方法 来处理ACK 确认**************************************/
    /**
     *
     * 设置交换机类型
     * DirectExchange:按照routingkey分发到指定队列
     * TopicExchange:多关键字匹配
     * FanoutExchange: 将消息分发到所有的绑定队列，无routingkey的概念
     * HeadersExchange ：通过添加属性key-value匹配
     */
    /*
   @Bean
    public DirectExchange defaultExchange() {

        return new DirectExchange(AmqpConfig.FOO_EXCHANGE);
    }

    //队列持久
    @Bean
    public Queue fooQueue() {
        return new Queue(AmqpConfig.FOO_QUEUE, true); //队列持久
    }

    @Bean
    public Binding binding() {
        //将队列绑定到交换机
        return BindingBuilder.bind(fooQueue()).to(defaultExchange()).with(AmqpConfig.FOO_ROUTINGKEY);
    }*/


    /**
     * 接受消息的监听，这个监听客户交易流水的消息
     * 针对消费者配置
     * @return
     */
  /* @Bean
    public SimpleMessageListenerContainer messageContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory());
        container.setQueues(fooQueue());
        container.setExposeListenerChannel(true);
        container.setMaxConcurrentConsumers(1);
        container.setConcurrentConsumers(1);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); //设置确认模式手工确认
        container.setMessageListener(new ChannelAwareMessageListener() {

            @Override
            public void onMessage(Message message, Channel channel) throws Exception {
                byte[] body = message.getBody();
                LOGGER.info("处理并确认消息"+message.getMessageProperties().getDeliveryTag()+" Listener onMessage : " + new String(body));
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false); //确认消息成功消费
            }
        });
        return container;
    }
*/

    //作用同上messageContainer，只是单独实现了transactionConsume
      /*  @Bean
    public SimpleMessageListenerContainer messageContainer1(TransactionConsumeImpl transactionConsume) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory());
        container.setQueues(fooQueue());
        container.setExposeListenerChannel(true);
        container.setMaxConcurrentConsumers(1);
        container.setConcurrentConsumers(1);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); //设置确认模式手工确认
        container.setMessageListener(transactionConsume);
        return container;
    }*/

}
