package com.github.Xswinger.blsslaboratorywork1.services;

import com.github.Xswinger.blsslaboratorywork1.entities.Model;
import com.github.Xswinger.blsslaboratorywork1.entities.ModelCountMessage;
import com.github.Xswinger.blsslaboratorywork1.messaging.sender.Sender;
import com.github.Xswinger.blsslaboratorywork1.repositories.ModelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service("models")
public class ModelServices {

    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private Sender sender;

    public void getModelsCounter() {
        List<Model> models = modelRepository.findAll();
        int countModels = models.size();

        log.info("Model Statics:");
        log.info("==============");
        log.info("model count: {}", countModels);
        log.info("==========================");

        ModelCountMessage message = new ModelCountMessage(countModels);
        Integer messageSend = message.getCount();

        sender.sendMessageFromUazToMain(messageSend);
    }
}
