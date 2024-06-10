package com.github.Xswinger.blsslaboratorywork1.delegates.addEntity;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.Xswinger.blsslaboratorywork1.entities.CarClass;
import com.github.Xswinger.blsslaboratorywork1.services.CarsService;

@Component
public class addCarClassProcess implements JavaDelegate {

    @Autowired
    private CarsService service;

    //TODO finish logic
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Long classId = Long.parseLong(execution.getVariable("car_class_id_add").toString());
        String className = execution.getVariable("car_class_name_add").toString();
        String classDescription = execution.getVariable("car_class_description_add").toString();

        CarClass carClass = new CarClass();
        carClass.setId(classId);
        carClass.setName(className);
        carClass.setDescription(classDescription);

        try {
            service.saveClass(carClass);
        } catch (Exception e) {
            execution.setVariable("car_class_result_add", "Error when adding new car class");
            return;
        }

        execution.setVariable("car_class_result_add", "New car class added");
    }

}
