package com.klinux.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .requestMatchers("/", "/home").permitAll()  // Permitir acceso sin autenticación a estas rutas
                .anyRequest().authenticated()             // Requiere autenticación para cualquier otra ruta
            .and()
            .oauth2Login();  // Configurar el login con OAuth2
        return http.build();
    }
}