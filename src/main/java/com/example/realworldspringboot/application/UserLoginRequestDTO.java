package com.example.realworldspringboot.application;

import com.example.realworldspringboot.domain.User;
import lombok.Getter;

@Getter
public class UserLoginRequestDTO {
    private final String email;
    private final String password;
    public UserLoginRequestDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public User toUser() {
        return User.fromEmailAndPassword(email, password);
    }
}
