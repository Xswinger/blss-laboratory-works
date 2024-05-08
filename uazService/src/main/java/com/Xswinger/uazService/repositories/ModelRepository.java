package com.Xswinger.uazService.repositories;

import com.Xswinger.uazService.entities.Model;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends CrudRepository<Model, Long> {
    
    @NonNull
    List<Model> findAll();
}
