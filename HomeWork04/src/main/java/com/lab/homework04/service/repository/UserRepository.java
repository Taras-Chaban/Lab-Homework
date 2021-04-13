package com.lab.homework04.service.repository;

import com.lab.homework04.service.model.User;

import java.util.ArrayList;

public interface UserRepository {
    User getUser(String email);

    ArrayList<User> getUsers(int start, int end);

    User createUser(User user);

    User updateUser(String email, User user);

    int getCountOfUsers();

    void deleteUser(String email);

}
