package com.klinux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klinux.dto.AuthenticationResponse;
import com.klinux.dto.LoginRequest;
import com.klinux.service.OpenAMAuthenticationService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final OpenAMAuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(OpenAMAuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            // Llamar al servicio de autenticación
            String token = authenticationService.authenticateUser(loginRequest.getUsername(), loginRequest.getPassword());

            if (token != null) {
                return ResponseEntity.ok(new AuthenticationResponse("Autenticación exitosa!", token));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new AuthenticationResponse("Error en la autenticación.", null));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new AuthenticationResponse("Error en el servidor.", null));
        }
    }
}