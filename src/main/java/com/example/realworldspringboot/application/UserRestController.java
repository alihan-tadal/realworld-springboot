package com.example.realworldspringboot.application;

import com.example.realworldspringboot.domain.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {
    private final UserRepository userRepository;
    public UserRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/user/login")
    public ResponseEntity<UserResponseDTO> login(@RequestBody UserLoginRequestDTO loginRequestDTO) {
        return ResponseEntity.of(userRepository.findFirstByEmailAndPassword(loginRequestDTO.getEmail(), loginRequestDTO.getPassword())
                .map(UserResponseDTO::fromUser));
    }

    @GetMapping("/user/login")
    public ResponseEntity testResponse() {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("This endpoint responds POST requests only.");
    }
}
