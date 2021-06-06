package com.cinemamicroservice.service.service;

import com.cinemamicroservice.service.models.User;
import com.cinemamicroservice.service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
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
}
