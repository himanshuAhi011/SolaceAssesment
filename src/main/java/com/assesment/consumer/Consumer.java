package com.assesment.consumer;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.TextMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class Consumer {

    List<String> quemessage = new ArrayList<String>();

    @JmsListener(destination = "test-first-topic")
    public void handle(Message message) {

        Date receiveTime = new Date();



        if (message instanceof TextMessage) {
            TextMessage tm = (TextMessage) message;
            try {
                System.out.println(
                        "Message Received at " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(receiveTime)
                                + " with message content of: " + tm.getText());
                quemessage.add(tm.getText());
            } catch (JMSException e) {
                System.out.println("error while consuming the message "+e);
            }
        } else {
            System.out.println("Invalid message"+ message);
        }

    }

}
