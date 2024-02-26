package com.github.Xswinger.blsslaboratorywork1.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.github.Xswinger.blsslaboratorywork1.entities.CarClass;

public interface ClassRepository extends CrudRepository<CarClass, Long> {
    
    List<CarClass> findAll();
}
