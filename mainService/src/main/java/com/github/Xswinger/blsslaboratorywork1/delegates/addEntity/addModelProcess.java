package com.github.Xswinger.blsslaboratorywork1.delegates.addEntity;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.Xswinger.blsslaboratorywork1.entities.CarClass;
import com.github.Xswinger.blsslaboratorywork1.entities.CarLineUp;
import com.github.Xswinger.blsslaboratorywork1.entities.Country;
import com.github.Xswinger.blsslaboratorywork1.entities.Model;
import com.github.Xswinger.blsslaboratorywork1.services.CarsService;

@Component
public class addModelProcess implements JavaDelegate {

    @Autowired
    private CarsService service;

    //TODO finish logic
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Model newModel = new Model();

        CarClass carClass = new CarClass();
        Long classId = Long.parseLong(execution.getVariable("car_class_id_add").toString());
        String className = execution.getVariable("car_class_name_add").toString();
        String classDescription = execution.getVariable("car_class_description_add").toString();
        carClass.setId(classId);
        carClass.setName(className);
        carClass.setDescription(classDescription);

        Country country = new Country();
        Long countryId = Long.parseLong(execution.getVariable("country_id_add").toString());
        String countryName = execution.getVariable("country_name_add").toString();
        country.setId(countryId);
        country.setName(countryName);

        CarLineUp lineUp = new CarLineUp();
        Long lineupId = Long.parseLong(execution.getVariable("line_up_id_add").toString());
        String lineupName = execution.getVariable("line_up_name_add").toString();
        lineUp.setId(lineupId);
        lineUp.setName(lineupName);
        //lineUp.setModels(null);

        Long modelId = Long.parseLong(execution.getVariable("model_id_add").toString());
        String modelName = execution.getVariable("model_name_add").toString();
        String modelDescription = execution.getVariable("model_description_add").toString();
        Integer modelCount = Integer.parseInt(execution.getVariable("model_count_add").toString());
        newModel.setId(modelId);
        newModel.setName(modelName);
        newModel.setDescription(modelDescription);
        newModel.setReleaseCount(modelCount);
        newModel.setCarClass(carClass);
        newModel.setCountry(country);
        newModel.setLineUp(lineUp);

        service.saveModel(newModel);

        execution.setVariable("", newModel);

    }

}
