package com.github.Xswinger.blsslaboratorywork1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.Xswinger.blsslaboratorywork1.entities.Brand;
// import com.github.Xswinger.blsslaboratorywork1.interfaces.TransportService;
import com.github.Xswinger.blsslaboratorywork1.repositories.BrandRepository;

import java.util.*;

@Service("trucks")
public class TrucksService {

    private final BrandRepository brandRepository;

    @Autowired
    TrucksService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<Brand>  getBrands() {
        List<Brand> brands = brandRepository.findAll();
        return brands;
    }
    
    
}
