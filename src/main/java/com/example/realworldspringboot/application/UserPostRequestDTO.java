package com.example.realworldspringboot.application;

import com.example.realworldspringboot.domain.User;
import lombok.Getter;

@Getter
public class UserPostRequestDTO {
    private  final String username;
    private  final String email;
    private final String password;

    public UserPostRequestDTO(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
    public User toUser() {
        return User.createNewUser(username, email, password);
    }
}
