package com.github.Xswinger.blsslaboratorywork1.interfaces;

import org.springframework.stereotype.Service;

import com.github.Xswinger.blsslaboratorywork1.entities.Brand;

@Service
public interface TransportService {
    
    Brand[] getBrands();

}
