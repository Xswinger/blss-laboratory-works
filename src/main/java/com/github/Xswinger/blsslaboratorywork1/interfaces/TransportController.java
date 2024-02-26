package com.github.Xswinger.blsslaboratorywork1.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.github.Xswinger.blsslaboratorywork1.entities.Brand;

public interface TransportController {

    @GetMapping("/")
    ResponseEntity<List<Brand>> getBrands();

}
