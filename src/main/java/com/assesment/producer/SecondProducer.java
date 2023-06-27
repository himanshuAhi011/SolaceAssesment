package com.assesment.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class SecondProducer {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("test-first-topic")
    private String queueName;

    public String sendEventFromSecondProducer() {
        for (int i = 0; i < 5; i++) {
            try {
                String msg = "Second PRODUCER Sending" + System.currentTimeMillis();
                System.out.println("==========SENDING MESSAGE========== " + msg);
                jmsTemplate.convertAndSend(queueName, msg);
            } catch (Exception e) {
                System.out.println("Error while sending the message from second producer" + e);
            }
        }
        return "5 Messages Sent From Second Producer";
    }
}
