package com.github.Xswinger.blsslaboratorywork1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import com.github.Xswinger.blsslaboratorywork1.entities.Brand;
import com.github.Xswinger.blsslaboratorywork1.entities.CarClass;
import com.github.Xswinger.blsslaboratorywork1.entities.Country;
import com.github.Xswinger.blsslaboratorywork1.entities.Model;
import com.github.Xswinger.blsslaboratorywork1.services.CarsService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "", maxAge = 3600)
public class AdminController {

    private final CarsService carsService;

    @Autowired
    AdminController(CarsService carService) {
        this.carsService = carService;
    }

    @PostMapping("/add/brand")
    public ResponseEntity<?> saveBrand(@RequestBody Brand newBrand) {
        try {
            return ResponseEntity.ok(carsService.saveBrand(newBrand));
        } catch (AuthenticationException e) {
            return new ResponseEntity<Enum<?>>(HttpStatus.UNAUTHORIZED);
        }
    }

    @DeleteMapping("/delete/brand")
    public ResponseEntity<?> removeBrand(@RequestParam("id") @NonNull Long id) {
        try {
            carsService.deleteBrand(id);
            return ResponseEntity.ok("ok");
        } catch (AuthenticationException e) {
            return new ResponseEntity<Enum<?>>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/add/model")
    public ResponseEntity<?> saveModel(@RequestBody @NonNull Model newModel) {
        try {
            return ResponseEntity.ok(carsService.saveModel(newModel));
        } catch (AuthenticationException e) {
            return new ResponseEntity<Enum<?>>(HttpStatus.UNAUTHORIZED);
        }
    }

    @DeleteMapping("/delete/model")
    public ResponseEntity<?> removeModel(@RequestParam("id") @NonNull Long id) {
        try {
            carsService.deleteModel(id);
            return ResponseEntity.ok("ok");
        } catch (AuthenticationException e) {
            return new ResponseEntity<Enum<?>>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/add/class")
    public ResponseEntity<?> saveClass(@RequestBody @NonNull CarClass newClass) {
        try {
            return ResponseEntity.ok(carsService.saveClass(newClass));
        } catch (AuthenticationException e) {
            return new ResponseEntity<Enum<?>>(HttpStatus.UNAUTHORIZED);
        }
    }

    @DeleteMapping("/delete/class")
    public ResponseEntity<?> removeClass(@RequestParam("id") @NonNull Long id) {
        try {
            carsService.deleteClass(id);
            return ResponseEntity.ok("ok");
        } catch (AuthenticationException e) {
            return new ResponseEntity<Enum<?>>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/add/country")
    public ResponseEntity<?> saveCountry(@RequestBody @NonNull Country newCountry) {
        try {
            return ResponseEntity.ok(carsService.saveCountry(newCountry));
        } catch (AuthenticationException e) {
            return new ResponseEntity<Enum<?>>(HttpStatus.UNAUTHORIZED);
        }
    }

    @DeleteMapping("/delete/country")
    public ResponseEntity<?> removeCountry(@RequestParam("id") @NonNull Long id) {
        try {
            carsService.deleteCountry(id);
            return ResponseEntity.ok("ok");
        } catch (AuthenticationException e) {
            return new ResponseEntity<Enum<?>>(HttpStatus.UNAUTHORIZED);
        }
    }
}