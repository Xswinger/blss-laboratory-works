package com.github.Xswinger.blsslaboratorywork1.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.github.Xswinger.blsslaboratorywork1.entities.Brand;

public interface BrandRepository extends CrudRepository<Brand, Long> {
    
    List<Brand> findAll();

    List<Brand> findAllByCountry_Id(Long id);
}
