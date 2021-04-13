package com.lab.homework04.service.repository.impl;

import com.lab.homework04.service.model.User;
import com.lab.homework04.service.repository.UserRepository;
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
                .orElseThrow(RuntimeException::new);
        log.info("Getting User by email: " + email);
        return user;
    }

    @Override
    public ArrayList<User> getUsers(int start, int end) {
        ArrayList<User> users = new ArrayList<>();
        while (start < end) {
            users.add(userList.get(start));
            start++;
        }
        return users;
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
    public int getCountOfUsers() {
        return userList.size();
    }

    @Override
    public void deleteUser(String email) {
        userList.removeIf(user -> user.getEmail().equals(email));
        log.info("User with id " + email + " was deleted");
    }


}
