package com.Xswinger.autoRuService.messaging.receiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.Xswinger.autoRuService.entities.Announcement;
import com.Xswinger.autoRuService.services.AnnouncementService;

@Component
public class Receiver {

    private final AnnouncementService service;

    @Autowired
    public Receiver(AnnouncementService service) {
        this.service = service;
    }

    @JmsListener(destination = "mainQueue", containerFactory = "jmsListenerContainerFactory")
    public Announcement receiveMessage(Announcement msg) {
        System.out.println("Message received from Main: " + msg);

        return service.closeAnnouncements(msg);
    }
}
