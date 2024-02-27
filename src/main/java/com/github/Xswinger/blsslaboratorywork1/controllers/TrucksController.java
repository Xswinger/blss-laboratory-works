package com.github.Xswinger.blsslaboratorywork1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.Xswinger.blsslaboratorywork1.entities.Brand;
import com.github.Xswinger.blsslaboratorywork1.interfaces.TransportController;
import com.github.Xswinger.blsslaboratorywork1.services.TrucksService;

import java.util.List;

@RestController
@RequestMapping("/trucks")
@CrossOrigin(origins = "", maxAge = 3600)
public class TrucksController implements TransportController{
    
    private final TrucksService service;

    @Autowired
    TrucksController(TrucksService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<Brand>> getBrands() {
        try {
            return ResponseEntity.ok(service.getBrands());
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

}
