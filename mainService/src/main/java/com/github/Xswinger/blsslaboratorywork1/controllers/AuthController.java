package com.github.Xswinger.blsslaboratorywork1.controllers;

import com.github.Xswinger.blsslaboratorywork1.entities.User;
import com.github.Xswinger.blsslaboratorywork1.security.domain.SignInRequest;
import com.github.Xswinger.blsslaboratorywork1.security.domain.SignUpRequest;
import com.github.Xswinger.blsslaboratorywork1.security.exception.UserAlreadyExistAuthenticationException;
import com.github.Xswinger.blsslaboratorywork1.security.service.AuthenticationService;
import com.github.Xswinger.blsslaboratorywork1.security.service.UserService;

import io.swagger.oas.annotations.Operation;
import jakarta.security.auth.message.AuthException;
import jakarta.validation.Valid;
import lombok.NonNull;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationService authenticationService;
    private final UserService service;

    public AuthController(AuthenticationService authenticationService, UserService userService) {
        this.authenticationService = authenticationService;
        this.service = userService;
    }

    @Operation(summary = "Регистрация пользователя")
    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@RequestBody @Valid SignUpRequest request) {
        try {
            return ResponseEntity.ok(authenticationService.signUp(request));
        } catch (UserAlreadyExistAuthenticationException e) {
            return ResponseEntity.status(401).build();
        }
    }

    @Operation(summary = "Авторизация пользователя")
    @PostMapping("/sign-in")
    public ResponseEntity<?> signIn(@RequestBody @Valid SignInRequest request) {
        try {
            return ResponseEntity.ok(authenticationService.signIn(request));
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(401).build();
        }
    }

    @PostMapping("/refresh-access")
    public ResponseEntity<?> giveAccess(@RequestParam("token") @NonNull String token) {
        try {
            User user = service.getCurrentUser();
            return ResponseEntity.ok(authenticationService.getAccessToken(token, user));
        } catch (AuthException e) {
            return ResponseEntity.status(401).build();
        }
    }

    @GetMapping("/get-admin")
    public void getAdmin() {
        service.getAdmin();    
    }
}