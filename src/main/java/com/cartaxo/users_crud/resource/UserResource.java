package com.cartaxo.users_crud.resource;

import com.cartaxo.users_crud.entities.User;
import com.cartaxo.users_crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api-users")
public class UserResource {

    @Autowired
    private UserService service; // Injeção de dependência da classe que contém as regras de negócio

    // Indica que a requisição do tipo GET para a url "http://localhost:8080/api-users/all" será encaminhada para o método abaixo
    @GetMapping("/all")
    public List<User> getUsers() {
        return service.findAll();
    }


}