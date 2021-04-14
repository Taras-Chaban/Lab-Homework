package com.lab.homework04.service.service;

import com.lab.homework04.service.dto.UserDto;

public interface UserService {
    UserDto getUser(String email);

    UserDto createUser(UserDto userDto);

    UserDto updateUser(String email, UserDto userDto);

    void deleteUser(String email);
}
