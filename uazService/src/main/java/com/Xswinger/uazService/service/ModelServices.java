package com.Xswinger.uazService.service;

import com.Xswinger.uazService.entities.Model;
import com.Xswinger.uazService.repositories.ModelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service("models")
public class ModelServices {
    private final ModelRepository modelRepository;

    @Autowired
    public ModelServices(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    public void getModelsCounter(){
        List<Model> models = modelRepository.findAll();
        int countModels = models.size();

        log.info("Model Statics:");
        log.info("==============");
        log.info("model count: {}", countModels);
        log.info("==========================");
    }
}
