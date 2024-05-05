package com.Xswinger.autoRuService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Xswinger.autoRuService.entities.Announcement;
import com.Xswinger.autoRuService.repositories.AnnouncementRepository;

@Service
public class AnnouncementService {

    private final AnnouncementRepository announcementRepository;

    @Autowired
    AnnouncementService(AnnouncementRepository announcementRepository) throws Throwable {
        this.announcementRepository = announcementRepository;
    }

    public Announcement getAnnouncement(Long id) {
        return announcementRepository.findById(id).get();
    }
    
    public Announcement closeAnnouncements(Announcement announcement) {
        return announcementRepository.save(announcement);
    }

}
