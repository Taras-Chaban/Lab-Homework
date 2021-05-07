package com.lab.homework6.service.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private Long id;
    private String name;
    private String password;
    private String phone;
    private String email;
    private String address;
    private Integer role;
}
