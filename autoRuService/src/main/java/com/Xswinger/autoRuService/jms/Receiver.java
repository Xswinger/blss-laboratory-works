package com.Xswinger.autoRuService.jms;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.Xswinger.autoRuService.entities.Announcement;

@Component
public class Receiver {

    private final JmsTemplate jmsTemplate;

    @Autowired
    public Receiver(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @JmsListener(destination = "msgQueue", containerFactory = "jmsListenerContainerFactory")
    public void receiveMessage(String msg) {
        System.out.println("Message received from Queue: " + msg);
    }

    public void sendMessage(Announcement announcement) { 
        System.out.println("Jms Message Sender : " + announcement); 
        Map<String, Object> map = new HashMap<>(); 
        map.put("modelId", announcement.getModelId()); map.put("price", announcement.getPrice()); 
        jmsTemplate.convertAndSend(map); 
    }
}
