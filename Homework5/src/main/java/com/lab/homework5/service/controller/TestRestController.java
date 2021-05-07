package com.lab.homework5.service.controller;

import com.lab.homework5.service.controller.model.UserModel;
import com.lab.homework5.service.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequiredArgsConstructor
@RequestMapping("/rest-template")
public class TestRestController {
    private final RestTemplate restTemplate;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{email}")
    public UserModel getUser(@PathVariable String email) {
        String url = "http://localhost:8080/api/v1/users/" + email;
        return restTemplate.getForObject(url, UserModel.class);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserModel createUser(@RequestBody UserDto userDto) {
        String url = "http://localhost:8080/api/v1/users";
        return restTemplate.postForObject(url, userDto, UserModel.class);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{emailUp}")
    public ResponseEntity<Void> updateUser(@PathVariable String emailUp, @RequestBody UserDto userDto) {
        String url = "http://localhost:8080/api/v1/users/" + emailUp;
        restTemplate.put(url, userDto, emailUp);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{emailDel}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteUser(@PathVariable String emailDel) {
        String url = "http://localhost:8080/api/v1/users/" + emailDel;
        restTemplate.delete(url, emailDel);
        return ResponseEntity.noContent().build();
    }
}
