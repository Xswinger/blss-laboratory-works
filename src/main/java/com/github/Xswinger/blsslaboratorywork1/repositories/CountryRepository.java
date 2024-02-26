package com.github.Xswinger.blsslaboratorywork1.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.github.Xswinger.blsslaboratorywork1.entities.Country;

public interface CountryRepository extends CrudRepository<Country, Long> {

    List<Country> findAll();
    
}
