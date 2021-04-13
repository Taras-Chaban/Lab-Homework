package com.lab.homework04.service.controller;

import com.lab.homework04.service.dto.UserDto;
import com.lab.homework04.service.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{email}")
    public UserDto getUser(@PathVariable String email) {
        return userService.getUser(email);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{currentPage}")
    public ArrayList<UserDto> getUsers(@PathVariable int currentPage) {
        final int USERS_NUMBER_ON_PAGE = 10;
        int countOfUsers = userService.getCuntOfUsers();
        int pages = (int) Math.round(countOfUsers / USERS_NUMBER_ON_PAGE + 0.5);
        int start = currentPage * USERS_NUMBER_ON_PAGE - USERS_NUMBER_ON_PAGE + 1;
        return userService.getUsers(start, start + USERS_NUMBER_ON_PAGE - 1);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{email}")
    public UserDto updateUser(@PathVariable String email, @RequestParam UserDto userDto) {
        return userService.updateUser(email, userDto);
    }

    @DeleteMapping(value = "/{email}")
    public ResponseEntity<Void> deleteUser(@PathVariable String email) {
        userService.deleteUser(email);
        return ResponseEntity.noContent().build();
    }
}
