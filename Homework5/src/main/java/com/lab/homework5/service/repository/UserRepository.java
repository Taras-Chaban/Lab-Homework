package com.lab.homework5.service.repository;

import com.lab.homework5.service.model.User;

public interface UserRepository {
    User getUser(String email);

    User createUser(User user);

    User updateUser(String email, User user);

    void deleteUser(String email);
}
