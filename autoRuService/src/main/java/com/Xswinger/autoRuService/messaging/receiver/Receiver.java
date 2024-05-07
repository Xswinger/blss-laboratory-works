package com.Xswinger.autoRuService.messaging.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @JmsListener(destination = "mainQueue", containerFactory = "jmsListenerContainerFactory")
    public void receiveMessage(String msg) {
        System.out.println("Message received from Main: " + msg);
    }
}
