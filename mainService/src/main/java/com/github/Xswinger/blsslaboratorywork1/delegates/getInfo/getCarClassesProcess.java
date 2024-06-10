package com.github.Xswinger.blsslaboratorywork1.delegates.getInfo;

import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.Xswinger.blsslaboratorywork1.entities.CarClass;
import com.github.Xswinger.blsslaboratorywork1.services.CarsService;

@Component
public class getCarClassesProcess implements JavaDelegate {

    @Autowired
    private CarsService service;

    //TODO finish logic
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        List<CarClass> carClasses = service.getCarClasses();
        StringBuilder results = new StringBuilder();

        List<String> groups = execution.getProcessEngineServices().getIdentityService().getCurrentAuthentication().getGroupIds();
        boolean isEnoughRights = groups.contains("camunda-admin") || groups.contains("admin");

        for (CarClass carClass: carClasses) {
            results.append(carClass.toString());
        }

        execution.setVariable("car_classes_viewer", results.toString());
    }

}
