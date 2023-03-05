package com.example.realworldspringboot.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
 public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findFirstByEmailAndPassword(String email, String password);
    boolean existsByEmail(String email);
}
