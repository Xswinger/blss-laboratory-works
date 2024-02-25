package com.github.Xswinger.blsslaboratorywork1.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.Xswinger.blsslaboratorywork1.interfaces.TransportController;

@RestController
@RequestMapping("/cars")
@CrossOrigin(origins = "", maxAge = 3600)
public class CarsController implements TransportController{
    
    @Override
    public ResponseEntity<Object[]> getModels() {
        try {

        } catch () {
            
        }
    }

    @GetMapping("/models")
    public ResponseEntity<Object[]> getCarModels() {
        try {

        } catch () {
            
        }
    }

    @GetMapping("/class")
    public ResponseEntity<Object[]> getCarClasses() {
        try {

        } catch () {
            
        }
    }

    @GetMapping("/class")
    public ResponseEntity<Object[]> getBrandsByCountries() {
        try {

        } catch () {
            
        }
    }

}
