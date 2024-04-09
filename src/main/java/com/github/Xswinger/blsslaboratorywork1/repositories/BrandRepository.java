package com.github.Xswinger.blsslaboratorywork1.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

import com.github.Xswinger.blsslaboratorywork1.entities.Brand;

public interface BrandRepository extends CrudRepository<Brand, Long> {
    
    @NonNull
    List<Brand> findAll();

    List<Brand> findAllByCountry_Id(Long id);
}
