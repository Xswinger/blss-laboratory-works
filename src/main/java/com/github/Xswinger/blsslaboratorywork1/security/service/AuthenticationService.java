package com.github.Xswinger.blsslaboratorywork1.security.service;

import com.github.Xswinger.blsslaboratorywork1.entities.User;
import com.github.Xswinger.blsslaboratorywork1.entities.enums.UserRole;
import com.github.Xswinger.blsslaboratorywork1.security.domain.JwtAuthenticationResponse;
import com.github.Xswinger.blsslaboratorywork1.security.domain.SignInRequest;
import com.github.Xswinger.blsslaboratorywork1.security.domain.SignUpRequest;

import io.jsonwebtoken.Claims;
import io.micrometer.common.lang.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
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

    public JwtAuthenticationResponse signUp(SignUpRequest request) {

        User user = new User(
                request.getUsername(),
                passwordEncoder.encode(request.getPassword()),
                UserRole.ROLE_USER
        );

        userService.create(user);

        String jwtAccess = jwtService.generateToken(user);
        String jwtRefresh = jwtService.generateRefreshToken(user);

        refreshStorage.put(user.getUsername(), jwtRefresh);

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

        refreshStorage.put(user.getUsername(), jwtRefresh);

        return new JwtAuthenticationResponse(jwtAccess, jwtRefresh);
    }

    public JwtAuthenticationResponse getAccessToken(@NonNull String refreshToken, @NonNull User currentUser) {
        if (jwtService.isTokenValid(refreshToken, (UserDetails) currentUser)) {
            final Claims claims = jwtService.getRefreshClaims(refreshToken);
            final String login = claims.getSubject();
            final String saveRefreshToken = refreshStorage.get(login);
            if (saveRefreshToken != null && saveRefreshToken.equals(refreshToken)) {
                final User user = userService.getByUsername(login);
                final String accessToken = jwtService.generateToken(user);
                return new JwtAuthenticationResponse(accessToken, null);
            }
        }
        return new JwtAuthenticationResponse(null, null);
    }
}
