package com.github.Xswinger.blsslaboratorywork1.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.Xswinger.blsslaboratorywork1.entities.Brand;

@RequestMapping("/default")
public interface TransportController {

    @GetMapping("/")
    ResponseEntity<Brand[]> getBrands();

}
