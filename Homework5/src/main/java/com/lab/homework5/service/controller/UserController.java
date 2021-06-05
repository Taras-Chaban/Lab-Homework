package com.lab.homework5.service.controller;

import com.lab.homework5.service.api.UserApi;
import com.lab.homework5.service.controller.assembler.UserAssembler;
import com.lab.homework5.service.controller.model.UserModel;
import com.lab.homework5.service.dto.UserDto;
import com.lab.homework5.service.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController implements UserApi {
    private final UserServiceImpl userService;
    private final UserAssembler userAssembler;

    @Override
    public UserModel getUser(String email) {
        log.info("Getting user with email{}", email);
        UserDto userDto = userService.getUser(email);
        return userAssembler.toModel(userDto);
    }

    @Override
    public UserModel createUser(UserDto userDto) {
        log.info("creating user{}", userDto);
        UserDto user = userService.createUser(userDto);
        return userAssembler.toModel(user);
    }

    @Override
    public UserModel updateUser(String emailUp, UserDto userDto) {
        log.info("Updating user with email{}", emailUp);
        UserDto user = userService.updateUser(emailUp, userDto);
        return userAssembler.toModel(user);
    }

    @Override
    public ResponseEntity<Void> deleteUser(String emailDel) {
        log.info("Deleting user with email{}", emailDel);
        userService.deleteUser(emailDel);
        return ResponseEntity.noContent().build();
    }
}
