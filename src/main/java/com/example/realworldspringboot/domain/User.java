package com.example.realworldspringboot.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    private long id;

    private String email;
    private String password;
    private String username;
    private String bio;
    private String image;

    public static User createNewUser(String username, String email, String password) {
        return new User(username, email, password);
    }

    private User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    protected User() {
    }
    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getBio() {
        return bio;
    }

    public String getImage() {
        return image;
    }
}
