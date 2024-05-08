package com.Xswinger.autoRuService.configuration.jms;

import jakarta.jms.ConnectionFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

import com.rabbitmq.jms.admin.RMQConnectionFactory;

@Configuration
@EnableJms
public class JMSConfiguration {

    @Value("${spring.jms.pub-sub-domain}")
    private Boolean pubSubDomain;

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setPubSubDomain(pubSubDomain);
        configurer.configure(factory, jmsConnectionFactory());
        return factory;
    }

    @Bean
    public ConnectionFactory jmsConnectionFactory() {
        RMQConnectionFactory connectionFactory = new RMQConnectionFactory();
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setVirtualHost("/");
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);
        return connectionFactory;
    }

}
