package com.lab.homework5.service.controller.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.lab.homework5.service.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
@AllArgsConstructor
public class UserModel extends RepresentationModel<UserModel> {
    @JsonUnwrapped
    private UserDto userDto;
}
