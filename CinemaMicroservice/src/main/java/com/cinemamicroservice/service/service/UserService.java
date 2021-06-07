package com.cinemamicroservice.service.service;

import com.cinemamicroservice.service.models.User;
import com.cinemamicroservice.service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Optional<User> getUser(String email) {
        Optional<User> user = userRepository.findByEmail(email);

        if (user.isEmpty()) {
            throw new RuntimeException("User not found!");
        }

        return user;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user, String email) {
        if (userRepository.existsByEmail(email)) {
            userRepository.deleteByEmail(email);
            return userRepository.save(user);
        } else {
            throw new RuntimeException("User not found");
        }

    }

    public ResponseEntity<Void> deleteUser(String email) {
        if (userRepository.existsByEmail(email)) {
            userRepository.deleteByEmail(email);
            return ResponseEntity.noContent().build();
        } else {
            throw new RuntimeException("User does not exist");
        }
    }
}
