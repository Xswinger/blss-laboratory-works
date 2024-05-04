package com.github.Xswinger.blsslaboratorywork1.security.domain;

import io.swagger.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Ответ c токеном доступа")
public class JwtAuthenticationResponse {
    public JwtAuthenticationResponse(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    @Schema(description = "Токен доступа", example = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTYyMjUwNj...")
    private String accessToken;

    private String refreshToken;

}
