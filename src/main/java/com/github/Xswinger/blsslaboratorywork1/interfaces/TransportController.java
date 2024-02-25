package com.github.Xswinger.blsslaboratorywork1.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/default")
public interface TransportController {

    @GetMapping("/")
    ResponseEntity<Object[]> getModels();

}
