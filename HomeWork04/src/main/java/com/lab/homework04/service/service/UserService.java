package com.lab.homework04.service.service;

import com.lab.homework04.service.dto.UserDto;
import com.lab.homework04.service.model.User;

import java.util.ArrayList;

public interface UserService {
    UserDto getUser(String email);

    ArrayList<UserDto> getUsers(int start, int end);

    UserDto createUser(UserDto userDto);

    UserDto updateUser(String email, UserDto userDto);

    void deleteUser(String email);

    int getCuntOfUsers();
}
