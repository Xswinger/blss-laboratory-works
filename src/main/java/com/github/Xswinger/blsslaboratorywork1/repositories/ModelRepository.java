package com.github.Xswinger.blsslaboratorywork1.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.Xswinger.blsslaboratorywork1.entities.Model;

@Repository
public interface ModelRepository extends CrudRepository<Model, Long> {
    
    List<Model> findAll();

    List<Model> findAllByCountry_IdAndLineUp_Id(Long countryId, Long lineUpId);
}
