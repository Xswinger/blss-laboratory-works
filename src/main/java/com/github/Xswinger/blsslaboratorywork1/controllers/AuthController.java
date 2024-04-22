package com.github.Xswinger.blsslaboratorywork1.controllers;

import com.github.Xswinger.blsslaboratorywork1.entities.User;
import com.github.Xswinger.blsslaboratorywork1.security.domain.JwtAuthenticationResponse;
import com.github.Xswinger.blsslaboratorywork1.security.domain.SignInRequest;
import com.github.Xswinger.blsslaboratorywork1.security.domain.SignUpRequest;
import com.github.Xswinger.blsslaboratorywork1.security.service.AuthenticationService;
import com.github.Xswinger.blsslaboratorywork1.security.service.UserService;

import io.swagger.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.NonNull;

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
    public JwtAuthenticationResponse signUp(@RequestBody @Valid SignUpRequest request) {
        return authenticationService.signUp(request);
    }

    @Operation(summary = "Авторизация пользователя")
    @PostMapping("/sign-in")
    public JwtAuthenticationResponse signIn(@RequestBody @Valid SignInRequest request) {
        return authenticationService.signIn(request);
    }

    @PostMapping("/refresh-access")
    public JwtAuthenticationResponse giveAccess(@RequestParam("token") @NonNull String token) {
        User user = service.getCurrentUser();
        return authenticationService.getAccessToken(token, user);
    }

    @GetMapping("/get-admin")
    public void getAdmin() {
        service.getAdmin();
    }
}