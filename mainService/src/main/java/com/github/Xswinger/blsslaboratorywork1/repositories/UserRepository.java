package com.github.Xswinger.blsslaboratorywork1.repositories;

import java.util.Optional;

import com.github.Xswinger.blsslaboratorywork1.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
}