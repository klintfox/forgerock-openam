package com.klinux.dto;

public class AuthenticationResponse {
    private String message;
    private String token;

    public AuthenticationResponse(String message, String token) {
        this.message = message;
        this.token = token;
    }

    // Getters
    public String getMessage() {
        return message;
    }

    public String getToken() {
        return token;
    }
}

