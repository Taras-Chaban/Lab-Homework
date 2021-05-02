package com.lab.homework5.service.api;

import com.lab.homework5.service.controller.model.UserModel;
import com.lab.homework5.service.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface UserApi {
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{email}")
    UserModel getUser(@PathVariable String email);

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    UserModel createUser(@RequestBody UserDto userDto);

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{emailUp}")
    UserModel updateUser(@PathVariable String emailUp, @RequestBody UserDto userDto);

    @DeleteMapping(value = "/{emailDel}")
    ResponseEntity<Void> deleteUser(@PathVariable String emailDel);
}
