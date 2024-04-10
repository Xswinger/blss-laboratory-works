package com.github.Xswinger.blsslaboratorywork1.controllers;

import com.github.Xswinger.blsslaboratorywork1.sequrity.JwtAuthenticationResponse;
import com.github.Xswinger.blsslaboratorywork1.sequrity.SignInRequest;
import com.github.Xswinger.blsslaboratorywork1.sequrity.SignUpRequest;
import com.github.Xswinger.blsslaboratorywork1.services.AuthenticationService;
import io.swagger.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationService authenticationService;

    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
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


}