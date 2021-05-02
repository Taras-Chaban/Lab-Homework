package com.lab.homework5.service.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;

@Data
@Builder
public class UserDto {
    private Long id;
    private String name;

    private String password;

    private String phone;

    private String email;
    private String address;
    private Integer role;
}
