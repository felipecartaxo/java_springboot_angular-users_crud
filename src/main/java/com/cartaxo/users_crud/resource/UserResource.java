package com.cartaxo.users_crud.resource;

import com.cartaxo.users_crud.entities.User;
import com.cartaxo.users_crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserResource {

    @Autowired
    private UserService service;

    public List<User> getUsers() {
        return service.findAll();
    }
}