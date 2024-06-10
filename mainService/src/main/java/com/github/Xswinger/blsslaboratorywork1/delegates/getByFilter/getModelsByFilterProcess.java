package com.github.Xswinger.blsslaboratorywork1.delegates.getByFilter;

import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.Xswinger.blsslaboratorywork1.entities.Brand;
import com.github.Xswinger.blsslaboratorywork1.entities.Model;
import com.github.Xswinger.blsslaboratorywork1.services.CarsService;

@Component
public class getModelsByFilterProcess implements JavaDelegate {

    @Autowired
    private CarsService service;

    //TODO finish logic
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        StringBuilder results = new StringBuilder();

        Long countryId = Long.parseLong(execution.getVariable("country_id_filter").toString());
        Long lineUpId = Long.parseLong(execution.getVariable("line_up_id_filter").toString());

        for (Model model: service.getModelsByFilter(countryId, lineUpId)) {
            results.append(model.toString()).append("\n");
        }

        execution.setVariable("models_viewer_filter", results.toString());
    }

}
