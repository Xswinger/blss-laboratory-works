package com.github.Xswinger.blsslaboratorywork1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.github.Xswinger.blsslaboratorywork1.configuration.atomikos.AtomikosConfig;
import com.github.Xswinger.blsslaboratorywork1.entities.Announcement;
import com.github.Xswinger.blsslaboratorywork1.messaging.receiver.Receiver;
import com.github.Xswinger.blsslaboratorywork1.messaging.sender.Sender;
import com.github.Xswinger.blsslaboratorywork1.repositories.AnnouncementRepository;

@Service("announcement")
public class AnnouncementService {

    private final Sender sender;

    private final Receiver receiver;

    private final PlatformTransactionManager transactionManager;

    private final AnnouncementRepository repository;

    @Autowired
    AnnouncementService(Sender sender, Receiver receiver, AnnouncementRepository repository, AtomikosConfig config) throws Throwable {
        this.repository = repository;
        this.sender = sender;
        this.receiver = receiver;
        this.transactionManager = config.transactionManager();
        sender.connect();
    }

    public List<Announcement> getAnnouncements() {
        List<Announcement> announcements = repository.findAll();
        return announcements;
    }

    public Announcement closeAnnouncements(Announcement announcement) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setIsolationLevel(DefaultTransactionDefinition.ISOLATION_READ_UNCOMMITTED);
        def.setPropagationBehavior(DefaultTransactionDefinition.PROPAGATION_REQUIRED);
        def.setName("countryCreating");

        TransactionStatus status = transactionManager.getTransaction(def);


        //TODO get answer from service
        try {
            sender.sendMessage(null, null);
            return repository.save(announcement);
            // receiver.receiveAutoRuMessage();
        } catch (Exception e) {
            transactionManager.rollback(status);
            return announcement;
        }

    }

}
