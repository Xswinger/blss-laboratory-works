package com.github.Xswinger.blsslaboratorywork1.delegates.buyCar;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.Xswinger.blsslaboratorywork1.services.AnnouncementService;

@Component
public class closeAnnouncementProcess implements JavaDelegate {

    @Autowired
    private AnnouncementService service;

    //TODO finish
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Integer announcementId = (Integer) execution.getVariable("announcement_id_number");

        String response = service.closeAnnouncements(announcementId);

        execution.setVariable("buy_car_response", response);
    }


}
