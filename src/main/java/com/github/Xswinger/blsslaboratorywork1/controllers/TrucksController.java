package com.github.Xswinger.blsslaboratorywork1.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.Xswinger.blsslaboratorywork1.interfaces.TransportController;

@RestController
@RequestMapping("/trucks")
@CrossOrigin(origins = "", maxAge = 3600)
public class TrucksController implements TransportController{
    
    @Override
    public ResponseEntity<Object[]> getModels() {
        try {

        } catch () {
            
        }
    }

}
