package com.github.Xswinger.blsslaboratorywork1.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.Xswinger.blsslaboratorywork1.entities.Announcement;

import io.micrometer.common.lang.NonNull;

@Repository
public interface AnnouncementRepository extends CrudRepository<Announcement, Long>{

    @NonNull
    List<Announcement> findAll();

    @NonNull
    Announcement save(Announcement announcement);

    @NonNull
    Optional<Announcement> findById(Long id);

}
