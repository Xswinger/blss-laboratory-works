package com.github.Xswinger.blsslaboratorywork1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.Xswinger.blsslaboratorywork1.entities.Announcement;
import com.github.Xswinger.blsslaboratorywork1.services.AnnouncementService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/announcement")
@CrossOrigin(origins = "", maxAge = 3600)
public class AnnouncementController {

    private final AnnouncementService service;

    @Autowired
    AnnouncementController(AnnouncementService service) {
        this.service = service;
    }

    @GetMapping("/get-announcements")
    public ResponseEntity<?> getAnnouncements() {
        try {
            return ResponseEntity.ok(service.getAnnouncements());
        } catch (AuthenticationException e) {
            return new ResponseEntity<Enum<?>>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/buy-model")
    public ResponseEntity<?> closeAnnouncement(@RequestBody @Valid Announcement announcement) throws Exception {
        try {
            return ResponseEntity.ok(service.closeAnnouncements(announcement.getId()));
        } catch (AuthenticationException e) {
            return new ResponseEntity<Enum<?>>(HttpStatus.UNAUTHORIZED);
        }
    }

}
