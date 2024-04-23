package com.github.Xswinger.blsslaboratorywork1.security.service;

import com.github.Xswinger.blsslaboratorywork1.entities.User;
import com.github.Xswinger.blsslaboratorywork1.entities.enums.UserRole;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.github.Xswinger.blsslaboratorywork1.repositories.UserRepository;
import com.github.Xswinger.blsslaboratorywork1.security.exception.UserAlreadyExistAuthenticationException;

@Service
public class UserService {

    final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User save(User user) {
        return repository.save(user);
    }

    public User create(User user) throws UserAlreadyExistAuthenticationException {
        if (repository.existsByUsername(user.getUsername())) {
            //! Заменить на свои исключения
            throw new UserAlreadyExistAuthenticationException("Пользователь с таким именем уже существует");
        }
        return save(user);
    }
    
    public User getByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));

    }

    public UserDetailsService userDetailsService() {
        return this::getByUsername;
    }

    public User getCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return getByUsername(username);
    }

    public void getAdmin() {
        User user = getCurrentUser();
        user.setRole(UserRole.ROLE_ADMIN);
        save(user);
    }
}