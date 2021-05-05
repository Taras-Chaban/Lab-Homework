package com.lab.homework5.service.service.impl;

import com.lab.homework5.service.dto.UserDto;
import com.lab.homework5.service.model.User;
import com.lab.homework5.service.repository.impl.UserRepositoryImpl;
import com.lab.homework5.service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepositoryImpl userRepository;

    @Override
    public UserDto getUser(String email) {
        User user = userRepository.getUser(email);
        return mapUserToUserDto(user);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = userRepository.createUser(mapUserDtoToUser(userDto));
        return mapUserToUserDto(user);
    }

    @Override
    public UserDto updateUser(String email, UserDto userDto) {
        User user = userRepository.updateUser(email, mapUserDtoToUser(userDto));
        return mapUserToUserDto(user);
    }

    @Override
    public void deleteUser(String email) {
        userRepository.deleteUser(email);
    }

    private UserDto mapUserToUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .phone(user.getPhone())
                .email(user.getEmail())
                .address(user.getAddress())
                .role(user.getRole())
                .password(user.getPassword())
                .build();
    }

    private User mapUserDtoToUser(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .phone(userDto.getPhone())
                .email(userDto.getEmail())
                .address(userDto.getAddress())
                .role(userDto.getRole())
                .password(userDto.getPassword())
                .build();
    }

}

