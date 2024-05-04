package com.github.Xswinger.blsslaboratorywork1.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.github.Xswinger.blsslaboratorywork1.entities.Announcement;

import io.micrometer.common.lang.NonNull;

public interface AnnouncementRepository extends CrudRepository<Announcement, Long>{

    @NonNull
    List<Announcement> findAll();

    @NonNull
    Announcement save(Announcement announcement);

}
