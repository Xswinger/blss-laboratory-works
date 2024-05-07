package com.github.Xswinger.blsslaboratorywork1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.github.Xswinger.blsslaboratorywork1.services.AnnouncementService;

public class AnnouncementController {

    private final AnnouncementService service;

    @Autowired
    AnnouncementController(AnnouncementService service) {
        this.service = service;
    }

    @GetMapping("/get-annoucement")
    public ResponseEntity<?> getAnnouncements() {
        try {
            return ResponseEntity.ok(service.getAnnouncements());
        } catch (AuthenticationException e) {
            return new ResponseEntity<Enum<?>>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/buy-model")
    public ResponseEntity<?> closeAnnouncement() {
        try {
            return ResponseEntity.ok(service.getAnnouncements());
        } catch (AuthenticationException e) {
            return new ResponseEntity<Enum<?>>(HttpStatus.UNAUTHORIZED);
        }
    }

}
