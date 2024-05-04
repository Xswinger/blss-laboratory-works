package com.github.Xswinger.blsslaboratorywork1.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

import com.github.Xswinger.blsslaboratorywork1.entities.CarClass;

public interface ClassRepository extends CrudRepository<CarClass, Long> {
    
    @NonNull
    List<CarClass> findAll();
}
