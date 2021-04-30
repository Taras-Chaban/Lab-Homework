package com.lab.homework5.service.repository.impl;

import com.lab.homework5.service.exception.UserNotFoundException;
import com.lab.homework5.service.model.User;
import com.lab.homework5.service.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class UserRepositoryImpl implements UserRepository {
    private final List<User> userList = new ArrayList<>();

    @Override
    public User getUser(String email) {
        User user = userList.stream()
                .filter(u -> u.getEmail().equals(email))
                .findFirst()
                .orElseThrow(UserNotFoundException::new);
        log.info("Get User by email: " + email);
        return user;
    }

    @Override
    public User createUser(User user) {
        userList.add(user);
        log.info("Created User " + user);
        return user;
    }

    @Override
    public User updateUser(String email, User user) {
        boolean isDeleted = userList.removeIf(u -> u.getEmail().equals(email));
        if (isDeleted) {
            userList.add(user);
        } else {
            throw new RuntimeException("User does not exist");
        }
        log.info("User with email " + email + " was updated");
        return user;
    }

    @Override
    public void deleteUser(String email) {
        boolean isDeleted = userList.removeIf(user -> user.getEmail().equals(email));
        if (!isDeleted) {
            log.info("User with email {} does not exist", email);
            throw new RuntimeException("User does not exist");
        } else {
            log.info("User with email {} was deleted", email);
        }
    }


}
