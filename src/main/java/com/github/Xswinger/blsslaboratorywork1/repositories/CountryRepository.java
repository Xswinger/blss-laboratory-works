package com.github.Xswinger.blsslaboratorywork1.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

import com.github.Xswinger.blsslaboratorywork1.entities.Country;

public interface CountryRepository extends CrudRepository<Country, Long> {

    @NonNull
    List<Country> findAll();
    
}
