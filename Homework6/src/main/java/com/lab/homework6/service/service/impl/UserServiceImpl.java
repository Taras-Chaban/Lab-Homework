package com.lab.homework6.service.service.impl;

import com.lab.homework6.service.dto.UserDto;
import com.lab.homework6.service.exception.UserNotFoundException;
import com.lab.homework6.service.model.User;
import com.lab.homework6.service.repository.UserRepository;
import com.lab.homework6.service.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDto getUser(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);
        log.info("Got User from DB by email: {}", email);
        return mapUserToUserDto(user);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = userRepository.save(mapUserDtoToUser(userDto));
        log.info("Created User in DB: {}", user);
        return mapUserToUserDto(user);
    }

    @Override
    public UserDto updateUser(String email, UserDto userDto) {
        if (!userRepository.existsByEmail(email)) {
            throw new UserNotFoundException();
        }
        User user = userRepository.save(mapUserDtoToUser(userDto));
        log.info("Updated user with email: {}", email);
        return mapUserToUserDto(user);
    }

    @Override
    public void deleteUser(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(UserNotFoundException::new);
        userRepository.delete(user);
        log.info("Deleted user with email: {}", email);
    }

    private UserDto mapUserToUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole())
                .password(user.getPassword())
                .build();
    }

    private User mapUserDtoToUser(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .email(userDto.getEmail())
                .role(userDto.getRole())
                .password(userDto.getPassword())
                .build();
    }

}

