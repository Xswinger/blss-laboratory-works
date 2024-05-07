package com.github.Xswinger.blsslaboratorywork1.messaging.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @JmsListener(destination = "autoRuQueue", containerFactory = "jmsListenerContainerFactory")
    public void receiveAutoRuMessage(String msg) {
        System.out.println("Message received from autoRu: " + msg);
    }

    @JmsListener(destination = "UazQueue", containerFactory = "jmsListenerContainerFactory")
    public void receiveUazMessage(String msg) {
        System.out.println("Message received from Uaz: " + msg);
    }
}
