package com.github.Xswinger.blsslaboratorywork1.security.service;

import com.github.Xswinger.blsslaboratorywork1.entities.User;
import com.github.Xswinger.blsslaboratorywork1.entities.enums.UserRole;
import com.github.Xswinger.blsslaboratorywork1.security.domain.JwtAuthenticationResponse;
import com.github.Xswinger.blsslaboratorywork1.security.domain.SignInRequest;
import com.github.Xswinger.blsslaboratorywork1.security.domain.SignUpRequest;

import io.jsonwebtoken.Claims;
import io.micrometer.common.lang.NonNull;
import jakarta.security.auth.message.AuthException;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final Map<String, String> refreshStorage = new HashMap<>();

    // public AuthenticationService(UserService userService, JwtService jwtService, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
    //     this.userService = userService;
    //     this.jwtService = jwtService;
    //     this.passwordEncoder = passwordEncoder;
    //     this.authenticationManager = authenticationManager;
    // }

    public JwtAuthenticationResponse signUp(SignUpRequest request) {

        User user = new User(
                request.getUsername(),
                passwordEncoder.encode(request.getPassword()),
                UserRole.ROLE_USER
        );

        userService.create(user);

        String jwtAccess = jwtService.generateToken(user);
        String jwtRefresh = jwtService.generateRefreshToken(user);

        return new JwtAuthenticationResponse(jwtAccess, jwtRefresh);
    }

    public JwtAuthenticationResponse signIn(SignInRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        ));

        User user = (User) userService
                .userDetailsService()
                .loadUserByUsername(request.getUsername());

        String jwtAccess = jwtService.generateToken(user);
        String jwtRefresh = jwtService.generateRefreshToken(user);

        return new JwtAuthenticationResponse(jwtAccess, jwtRefresh);
    }

    public JwtAuthenticationResponse getAccessToken(@NonNull String refreshToken) {
        // if (jwtService.isTokenValid(refreshToken)) {
            final Claims claims = jwtService.getRefreshClaims(refreshToken);
            final String login = claims.getSubject();
            final String saveRefreshToken = refreshStorage.get(login);
            if (saveRefreshToken != null && saveRefreshToken.equals(refreshToken)) {
                final User user = userService.getByUsername(login);
                final String accessToken = jwtService.generateToken(user);
                return new JwtAuthenticationResponse(accessToken, null);
            }
        // }
        return new JwtAuthenticationResponse(null, null);
    }

    public JwtAuthenticationResponse refresh(@NonNull String refreshToken) throws AuthException {
        // if (jwtService.isTokenValid(refreshToken)) {
            final Claims claims = jwtService.getRefreshClaims(refreshToken);
            final String login = claims.getSubject();
            final String saveRefreshToken = refreshStorage.get(login);
            if (saveRefreshToken != null && saveRefreshToken.equals(refreshToken)) {
                final User user = userService.getByUsername(login);
                final String accessToken = jwtService.generateToken(user);
                final String newRefreshToken = jwtService.generateRefreshToken(user);
                refreshStorage.put(user.getUsername(), newRefreshToken);
                return new JwtAuthenticationResponse(accessToken, newRefreshToken);
            }
        // }
        throw new AuthException("Невалидный JWT токен");
    }
}
