package com.example.realworldspringboot.application;

import lombok.Getter;

@Getter
public class UserLoginRequestDTO {
    private final String email;
    private final String password;
    public UserLoginRequestDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
