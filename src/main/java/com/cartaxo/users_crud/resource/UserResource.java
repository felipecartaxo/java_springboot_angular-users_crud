package com.cartaxo.users_crud.resource;

import com.cartaxo.users_crud.entities.User;
import com.cartaxo.users_crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Indica que esta classe é uma API RESTful
@RequestMapping("/api/users") // Define que todos os endpoints definidos nesta classe serão acessados a partir de /api/users
public class UserResource {

    @Autowired
    private UserService service; // Injeção de dependência da classe que contém as regras de negócio

    // Retorna todos os usuários
    @GetMapping // Indica que a requisição do tipo GET para a url "http://localhost:8080/api/users" será encaminhada para o método abaixo
    public List<User> getUsers() {
        return service.findAll();
    }

    // Retorna um usuário a partir do id passado na URL
    @GetMapping("/{id}") // Responde a requisições GET feitas para /api/users/{id}. Serve para obter os detalhes de um usuário a partir de um id
    public User getUser(@PathVariable Long id) { // O id do usuário é extraído da URL e passado como argumento
        return service.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @PostMapping // Este método será chamado quando uma requisição HTTP do tipo POST for feita para /api/users. É utilizado para criar um novo usuário
    // Cria um usuário
    public User createUser(@RequestBody User user) { // Determina que o corpo da requisição será transformado em uma instância da classe User e passado para o método
        return service.createUser(user); // Retorna o usuário criado
    }
}