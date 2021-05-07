package com.lab.homework6.service;

import org.springframework.web.client.RestTemplate;

public class Application {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        //UserModel userModel = restTemplate.getForObject("http://localhost:8080/api/v1/users/admin@email.com", UserModel.class);

        String resp = restTemplate.getForObject("https://google.com", String.class);
        System.out.println(resp);
    }
}