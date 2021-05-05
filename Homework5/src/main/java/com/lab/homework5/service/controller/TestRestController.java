package com.lab.homework5.service.controller;

import com.lab.homework5.service.controller.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequiredArgsConstructor
public class TestRestController {
    private final RestTemplate restTemplate;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/rest-template/{email}")
    public UserModel getUser(@PathVariable String email) {
        String url = "http://localhost:8080/api/v1/users/" + email;
        return restTemplate.getForObject(url, UserModel.class);
    }
}
