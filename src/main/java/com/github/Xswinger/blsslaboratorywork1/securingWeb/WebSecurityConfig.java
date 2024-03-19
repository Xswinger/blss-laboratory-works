package com.github.Xswinger.blsslaboratorywork1.securingWeb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http//Доступ к страницам / и /home для всех с аутентификацией
            .authorizeHttpRequests((requests) -> requests
                .requestMatchers("/", "/home").permitAll().anyRequest().authenticated()
            ).formLogin((form) -> form //спецификация базовой формы аутентификации
                .loginPage("/login")
                .permitAll()
            ).logout((logout) -> logout.permitAll());

        return http.build();
    }
}
