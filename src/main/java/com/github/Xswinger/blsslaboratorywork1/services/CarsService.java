package com.github.Xswinger.blsslaboratorywork1.services;

import org.springframework.stereotype.Service;

import com.github.Xswinger.blsslaboratorywork1.interfaces.TransportService;

@Service("cars")
public class CarsService implements TransportService{

    @Override
    public Object[] getModels() {
        
    }
    
}
