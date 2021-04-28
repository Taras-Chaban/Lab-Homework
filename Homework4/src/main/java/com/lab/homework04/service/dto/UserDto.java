package com.lab.homework04.service.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;

@Data
@Builder
public class UserDto {
    @NotNull
    @Size(min = 4)
    private String name;

    @NotNull
    private String password;

    @Size(min = 9, max = 12)
    private String phone;

    @Email
    @NotNull
    private String email;
    private String address;

    @Min(1)
    @Max(5)
    @NotNull
    private Integer role;
}
