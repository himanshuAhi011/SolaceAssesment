package com.assesment.producer;

import jakarta.jms.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class ProducerConfig {

    @Autowired
    ConnectionFactory connectionFactory;


    @Bean
    public JmsTemplate customizeJmsTemplate() {

        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(connectionFactory);

        return new JmsTemplate(cachingConnectionFactory);
    }
}
