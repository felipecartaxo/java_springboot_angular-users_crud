package com.cartaxo.users_crud.service;

import com.cartaxo.users_crud.entities.User;
import com.cartaxo.users_crud.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Diz para o Spring que esta é a classe que contém a lógica principal das regras de negócio da nossa aplicação
public class UserService {
    @Autowired // Injeção de dependência
    public UserRepository repository;

    // Cria e salva um usuário
    public User createUser(User user) {
        return repository.save(user);
    }

    // Retorna todos os usuários registrados
    public List<User> findAll() {
        return repository.findAll();
    }

    // Retorna um usuário específico
    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }

    public User updateUser(Long id, User obj) {
        User entity = repository.getReferenceById(id);
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());

        return repository.save(entity);
    }
}