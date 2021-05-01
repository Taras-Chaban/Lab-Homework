package com.lab.homework5.service.controller.assembler;

import com.lab.homework5.service.controller.UserController;
import com.lab.homework5.service.controller.model.UserModel;
import com.lab.homework5.service.dto.UserDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UserAssembler extends RepresentationModelAssemblerSupport<UserDto, UserModel> {

    public UserAssembler() {
        super(UserController.class, UserModel.class);
    }

    @Override
    public UserModel toModel(UserDto entity) {
        UserModel userModel = new UserModel(entity);

        Link get = linkTo(methodOn(UserController.class).getUser(entity.getEmail())).withRel("get");
        Link update = linkTo(methodOn(UserController.class).getUser(entity.getEmail())).withRel("update");
        Link create = linkTo(methodOn(UserController.class).getUser(entity.getEmail())).withRel("create");

        userModel.add(get, update, create);

        return userModel;
    }
}
