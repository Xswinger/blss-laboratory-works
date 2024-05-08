package com.github.Xswinger.blsslaboratorywork1.configuration.jms;

import jakarta.jms.ConnectionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.transaction.PlatformTransactionManager;

import com.github.Xswinger.blsslaboratorywork1.configuration.atomikos.AtomikosConfig;
import com.rabbitmq.jms.admin.RMQConnectionFactory;

@Configuration
@EnableJms
public class JMSConfiguration {

    @Value("${spring.jms.pub-sub-domain}")
    private Boolean pubSubDomain;

    private final PlatformTransactionManager transactionManager;

    @Autowired
    JMSConfiguration(AtomikosConfig config) throws Throwable {
        this.transactionManager = config.transactionManager();
    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        configurer.configure(factory, jmsConnectionFactory());
        factory.setSessionTransacted(true);
        factory.setPubSubDomain(pubSubDomain);
        factory.setTransactionManager(transactionManager);
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
