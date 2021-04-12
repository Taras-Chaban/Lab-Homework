package com.lab.homework04.service.model;

import lombok.Data;

@Data
public class User {
    private String name;
    private String password;
    private String phone;
    private String email;
    private String address;
    private Integer role;
}
