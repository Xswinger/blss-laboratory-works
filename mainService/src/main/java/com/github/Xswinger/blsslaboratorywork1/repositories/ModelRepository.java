package com.github.Xswinger.blsslaboratorywork1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import com.github.Xswinger.blsslaboratorywork1.entities.Model;

@Repository
public interface ModelRepository extends CrudRepository<Model, Long> {
    
    @NonNull
    List<Model> findAll();

    List<Model> findAllByCountry_IdAndLineUp_Id(Long countryId, Long lineUpId);
    
    @Query(value = "SELECT * FROM MODEL WHERE CLASS_ID = ?1 ORDER BY random() LIMIT 3", nativeQuery = true)
    List<Model> findThreeRandomByCarClass(Long carClassId);
}
