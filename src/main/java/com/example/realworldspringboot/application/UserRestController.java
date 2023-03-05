package com.example.realworldspringboot.application;

import com.example.realworldspringboot.domain.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {
    private final UserService userService;
    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> login(@RequestBody UserLoginRequestDTO loginRequestDTO) {
        return ResponseEntity.of(userService.login(loginRequestDTO.getEmail(), loginRequestDTO.getPassword())
                .map(UserResponseDTO::fromUser));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserResponseDTO postUser(@RequestBody UserPostRequestDTO userPostRequestDTO) {
        return UserResponseDTO.fromUser(
                userService.createUser(userPostRequestDTO.toUser())
        );
    }
}
