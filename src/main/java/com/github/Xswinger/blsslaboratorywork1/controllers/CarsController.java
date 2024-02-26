package com.github.Xswinger.blsslaboratorywork1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.Xswinger.blsslaboratorywork1.interfaces.TransportController;
import com.github.Xswinger.blsslaboratorywork1.interfaces.TransportService;
import com.github.Xswinger.blsslaboratorywork1.services.CarsService;
import com.github.Xswinger.blsslaboratorywork1.entities.Brand;
import com.github.Xswinger.blsslaboratorywork1.entities.CarClass;
import com.github.Xswinger.blsslaboratorywork1.entities.Model;

@RestController
@RequestMapping("/cars")
@CrossOrigin(origins = "", maxAge = 3600)
public class CarsController implements TransportController{

    private final CarsService service;

    @Autowired
    CarsController(CarsService service) {
        this.service = service;
    }
    
    @Override
    public ResponseEntity<Brand[]> getBrands() {
        try {
            return ResponseEntity.ok(service.getBrands());
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/models")
    public ResponseEntity<Model[]> getModels() {
        try {
            return ResponseEntity.ok(service.getModels());
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/class")
    public ResponseEntity<CarClass[]> getClasses() {
        try {
            return ResponseEntity.ok(service.getCarClasses());
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/class")
    public ResponseEntity<Object[]> getBrandsByCountries() {
        try {
            return ResponseEntity.ok(service.getBrands());
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

}
