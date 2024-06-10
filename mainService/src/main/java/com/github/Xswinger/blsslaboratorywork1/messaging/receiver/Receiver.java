package com.github.Xswinger.blsslaboratorywork1.messaging.receiver;

import java.nio.ByteBuffer;
import java.util.concurrent.CompletableFuture;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.github.Xswinger.blsslaboratorywork1.configuration.atomikos.AtomikosConfig;
import com.github.Xswinger.blsslaboratorywork1.configuration.mqtt.MqttConfiguration;
import com.github.Xswinger.blsslaboratorywork1.messaging.sender.Sender;
import com.github.Xswinger.blsslaboratorywork1.services.AnnouncementService;
import com.github.Xswinger.blsslaboratorywork1.services.FutureService;

import jakarta.annotation.PostConstruct;

@Component
public class Receiver {

    @Autowired
    private IMqttClient mqttClient;

    @Autowired
    private MqttConfiguration configuration;

    @Autowired
    private AnnouncementService service;

    @Autowired
    private Sender sender;

    @Autowired
    private FutureService futureService;
    // private final ConcurrentMap<Long, CompletableFuture<Long>> responseFutures = new ConcurrentHashMap<>();
    private final PlatformTransactionManager transactionManager;

    @Autowired
    Receiver(AtomikosConfig config) throws Throwable {
        this.transactionManager = config.transactionManager();
    }

    @PostConstruct
    public void subscribeFromAutoRu() throws Exception {
        mqttClient.subscribe(configuration.mainTopic, (topic, msg) -> {
            try {
                byte[] payload = msg.getPayload();

                Long id = ByteBuffer.wrap(payload).getLong();

                System.out.println("Received message from autoRu: " + id);

                CompletableFuture<Long> future = futureService.getResponseFutures().remove(id);
                if (future != null && id != -1) {
                    future.complete(id);
                } else {
                    throw new Exception("Announcement already solved or not exist");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @PostConstruct
    public void subscribeFromMain() throws Exception {
        mqttClient.subscribe(configuration.autoRuTopic, (topic, msg) -> {
            
            DefaultTransactionDefinition def = new DefaultTransactionDefinition();
            def.setIsolationLevel(DefaultTransactionDefinition.ISOLATION_READ_UNCOMMITTED);
            def.setPropagationBehavior(DefaultTransactionDefinition.PROPAGATION_REQUIRED);
            def.setName("carBuying");

            TransactionStatus status = transactionManager.getTransaction(def);

            try {
                byte[] payload = msg.getPayload();

                Long id = ByteBuffer.wrap(payload).getLong();

                System.out.println("Received message from main: " + id);

                Long returnedId = service.closeAnnouncements(id);

                sender.sendMessageFromAutoRuToMain(returnedId);

                System.out.println("Send message to main: " + returnedId);

                transactionManager.commit(status);
            } catch (Exception e) {
                transactionManager.rollback(status);
                e.printStackTrace();
                sender.sendMessageFromAutoRuToMain(Long.valueOf(-1));
            }
        });
    }

    @PostConstruct
    public void subscribeUaz() throws Exception {
        mqttClient.subscribe(configuration.uazTopic, (topic, msg) -> {
            byte[] payload = msg.getPayload();
            Long id = ByteBuffer.wrap(payload).getLong();
            System.out.println("Received message from uaz: " + id);
        });
    }
}
