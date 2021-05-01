package com.lab.homework5.service.controller;

import com.lab.homework5.service.controller.assembler.UserAssembler;
import com.lab.homework5.service.controller.model.UserModel;
import com.lab.homework5.service.dto.UserDto;
import com.lab.homework5.service.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserServiceImpl userService;
    private final UserAssembler userAssembler;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{email}", method = RequestMethod.GET)
    public UserModel getUser(@PathVariable String email) {
        log.info("Getting user with email{}", email);
        UserDto userDto = userService.getUser(email);
        return userAssembler.toModel(userDto);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserModel createUser(@RequestBody UserDto userDto) {
        log.info("creating user{}", userDto);
        UserDto user =  userService.createUser(userDto);
        return userAssembler.toModel(user);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{emailUp}")
    public UserModel updateUser(@PathVariable String emailUp, @RequestParam UserDto userDto) {
        log.info("Updating user with email{}", emailUp);
        UserDto user = userService.updateUser(emailUp, userDto);
        return userAssembler.toModel(user);
    }

    @DeleteMapping(value = "/{emailDel}")
    public ResponseEntity<Void> deleteUser(@PathVariable String emailDel) {
        log.info("Deleting user with email{}", emailDel);
        userService.deleteUser(emailDel);
        return ResponseEntity.noContent().build();
    }
}
