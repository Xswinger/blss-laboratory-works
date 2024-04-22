package com.github.Xswinger.blsslaboratorywork1.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public interface TransportController {

    @GetMapping("/")
    ResponseEntity<?> getBrands();

}
