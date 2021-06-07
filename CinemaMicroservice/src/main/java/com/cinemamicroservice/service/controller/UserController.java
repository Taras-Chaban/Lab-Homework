package com.cinemamicroservice.service.controller;

import com.cinemamicroservice.service.models.User;
import com.cinemamicroservice.service.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("cinema/users")
public class UserController {
    private final UserService userService;

    @GetMapping(value = "/{email}")
    @ResponseStatus(HttpStatus.FOUND)
    public Optional<User> getUser(@PathVariable String email) {
        log.info("Getting user by email: {}", email);
        return userService.getUser(email);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        log.info("Creating user: {}", user);
        return userService.createUser(user);
    }

    @PutMapping(value = "/{email}")
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(@PathVariable String email, @RequestBody User user) {
        log.info("Updating user with email: {}", email);
        return userService.updateUser(user, email);
    }

    @DeleteMapping(value = "/{email}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> deleteUser(@PathVariable String email) {
        log.info("Deleting user with email: {}", email);
        return userService.deleteUser(email);
    }
}
