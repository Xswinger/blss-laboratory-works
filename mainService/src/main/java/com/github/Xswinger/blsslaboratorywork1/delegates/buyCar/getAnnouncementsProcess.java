package com.github.Xswinger.blsslaboratorywork1.delegates.buyCar;

import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.Xswinger.blsslaboratorywork1.entities.Announcement;
import com.github.Xswinger.blsslaboratorywork1.services.AnnouncementService;

@Component
public class getAnnouncementsProcess implements JavaDelegate {

    @Autowired
    private AnnouncementService service;

    //TODO check logic
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        List<Announcement> announcements = service.getAnnouncements();
        StringBuilder result = new StringBuilder();
        for (Announcement announcement : announcements) {
            result.append(announcement.toString()).append("\n");
        }
        execution.setVariable("buy_car_all_announcements", result.toString());
    }

}
