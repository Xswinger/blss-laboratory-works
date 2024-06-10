package com.github.Xswinger.blsslaboratorywork1.delegates.addEntity;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.Xswinger.blsslaboratorywork1.entities.Country;
import com.github.Xswinger.blsslaboratorywork1.services.CarsService;

@Component
public class addCountryProcess implements JavaDelegate {

    @Autowired
    private CarsService service;

    //TODO finish logic
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Long countryId = Long.parseLong(execution.getVariable("country_id_add").toString());
        String countryName = execution.getVariable("country_id_add").toString();

        Country country = new Country();
        country.setId(countryId);
        country.setName(countryName);

        try {
            service.saveCountry(country);
        } catch (Exception e) {
            execution.setVariable("country_result_add", "Error when adding new country");
            return;
        }

        execution.setVariable("country_result_add", "New country added");

    }

}
