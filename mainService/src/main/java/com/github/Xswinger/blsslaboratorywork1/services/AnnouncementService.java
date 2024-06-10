package com.github.Xswinger.blsslaboratorywork1.services;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.github.Xswinger.blsslaboratorywork1.configuration.atomikos.AtomikosConfig;
import com.github.Xswinger.blsslaboratorywork1.entities.Announcement;
import com.github.Xswinger.blsslaboratorywork1.messaging.sender.Sender;
import com.github.Xswinger.blsslaboratorywork1.repositories.AnnouncementRepository;

@Service("announcement")
public class AnnouncementService {

    private final Sender sender;

    private final PlatformTransactionManager transactionManager;

    private final AnnouncementRepository repository;

    private FutureService futureService;

    @Autowired
    AnnouncementService(FutureService futureService, Sender sender, AnnouncementRepository repository, AtomikosConfig config) throws Throwable {
        this.repository = repository;
        this.sender = sender;
        this.futureService = futureService;
        this.transactionManager = config.transactionManager();
    }

    public List<Announcement> getAnnouncements() {
        List<Announcement> announcements = repository.findAll();
        return announcements;
    }

    public String closeAnnouncements(Integer announcementId) throws InterruptedException, ExecutionException {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setIsolationLevel(DefaultTransactionDefinition.ISOLATION_READ_UNCOMMITTED);
        def.setPropagationBehavior(DefaultTransactionDefinition.PROPAGATION_REQUIRED);
        def.setName("carBuying");

        TransactionStatus status = transactionManager.getTransaction(def);
        CompletableFuture<Long> responseFuture = futureService.addResponseFuture((long) announcementId);
        responseFuture.orTimeout(2000, TimeUnit.MILLISECONDS);

        try {
            sender.sendMessageFromMainToAutoRu(announcementId);
            String answer = responseFuture.thenApply(response -> "Announcement with id " + response + " buyed successfully")
                .exceptionally(ex -> "Announcement already solved or not exist").get();
            transactionManager.commit(status);
            return answer;
        } catch (Exception e) {
            transactionManager.rollback(status);
            return responseFuture.thenApply(response -> "Announcement with id " + response + " buyed successfully")
                            .exceptionally(ex -> "Announcement already solved or not exist").get();
        }
    }

    public Long closeAnnouncements(Long id) throws Exception {
        Announcement announcement = repository.findById(id).get();

        if (announcement.isRelevance()) {
            announcement.setRelevance(false);
        } else {
            return Long.valueOf(-1);
        }

        return repository.save(announcement).getId();
    }

    public CompletableFuture<Long> addResponseFuture(Long messageId) {
        CompletableFuture<Long> future = new CompletableFuture<>();
        futureService.getResponseFutures().put(messageId, future);
        return future;
    }

}
