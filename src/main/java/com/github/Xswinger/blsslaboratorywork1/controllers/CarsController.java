package com.github.Xswinger.blsslaboratorywork1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.Xswinger.blsslaboratorywork1.interfaces.TransportController;
import com.github.Xswinger.blsslaboratorywork1.services.CarsService;

@RestController
@RequestMapping("/cars")
@CrossOrigin(origins = "", maxAge = 3600)
public class CarsController implements TransportController {

    private final CarsService service;

    @Autowired
    CarsController(CarsService service) {
        this.service = service;
    }
    
    @Override
    public ResponseEntity<?> getBrands() {
        try {
            return ResponseEntity.ok(service.getBrands());
        } catch (DataAccessException e) {
            return new ResponseEntity<Enum<?>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/country/{id}")
    public ResponseEntity<?> getBrandsByCountry(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.getBrandsByCountry(id));
        } catch (DataAccessException e) {
            return new ResponseEntity<Enum<?>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/models")
    public ResponseEntity<?> getModels() {
        try {
            return ResponseEntity.ok(service.getModels());
        } catch (DataAccessException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<Enum<?>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/class")
    public ResponseEntity<?> getClasses() {
        try {
            return ResponseEntity.ok(service.getCarClasses());
        } catch (DataAccessException e) {
            return new ResponseEntity<Enum<?>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/country")
    public ResponseEntity<?> getCountries() {
        try {
            return ResponseEntity.ok(service.getCountries());
        } catch (DataAccessException e) {
            return new ResponseEntity<Enum<?>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/filter")
    public ResponseEntity<?> getModelByFilter(
            @RequestParam("country") Long countryId,
            @RequestParam("lineup") Long lineUpId
        ) {
        try {
            return ResponseEntity.ok(service.getModelsByFilter(countryId, lineUpId));
        } catch (DataAccessException e) {
            return new ResponseEntity<Enum<?>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/random")
    public ResponseEntity<?> getRandomByClass(
            @RequestParam("class") Long classId
        ) {
        try {
            return ResponseEntity.ok(service.getRandomClassesByCarClass(classId));
        } catch (DataAccessException e) {
            return new ResponseEntity<Enum<?>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
