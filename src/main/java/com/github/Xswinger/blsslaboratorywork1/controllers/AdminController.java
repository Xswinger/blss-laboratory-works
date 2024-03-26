package com.github.Xswinger.blsslaboratorywork1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<List<Brand>> saveBrand(@RequestBody Brand newBrand) {
        try {
            return ResponseEntity.ok(carsService.saveBrand(newBrand));
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/brand")
    public ResponseEntity<String> removeBrand(@RequestParam("id") @NonNull Long id) {
        try {
            carsService.deleteBrand(id);
            return ResponseEntity.ok("ok");
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add/model")
    public ResponseEntity<Model> saveModel(@RequestBody @NonNull Model newModel) {
        try {
            return ResponseEntity.ok(carsService.saveModel(newModel));
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/model")
    public ResponseEntity<String> removeModel(@RequestParam("id") @NonNull Long id) {
        try {
            carsService.deleteModel(id);
            return ResponseEntity.ok("ok");
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add/class")
    public ResponseEntity<CarClass> saveClass(@RequestBody @NonNull CarClass newClass) {
        try {
            return ResponseEntity.ok(carsService.saveClass(newClass));
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/class")
    public ResponseEntity<String> removeClass(@RequestParam("id") @NonNull Long id) {
        try {
            carsService.deleteClass(id);
            return ResponseEntity.ok("ok");
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add/country")
    public ResponseEntity<Country> saveCountry(@RequestBody @NonNull Country newCountry) {
        try {
            return ResponseEntity.ok(carsService.saveCountry(newCountry));
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/country")
    public ResponseEntity<String> removeCountry(@RequestParam("id") @NonNull Long id) {
        try {
            carsService.deleteCountry(id);
            return ResponseEntity.ok("ok");
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}