package com.cartaxo.users_crud.service;

import com.cartaxo.users_crud.entities.User;
import com.cartaxo.users_crud.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Diz para o Spring que esta é a classe que contém a lógica principal das regras de negócio da nossa aplicação
public class UserService {
    @Autowired // Injeção de dependência do repositório que contém os métodos de persistência
    public UserRepository repository;

    // Cria e salva, no banco, um usuário
    public User createUser(User user) {
        return repository.save(user);
    }

    // Retorna todos os usuários registrados no banco
    public List<User> findAll() {
        return repository.findAll();
    }

    // Retorna um usuário específico que está registrado no banco
    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }

    // Atualiza o nome e email de um determinado usuário. Observe que passamos o id do usuário que desejamos atualizar e, no corpo da requisição, será passado um JSON contendo os dados atualizados. Após isso, o dado será salvo no banco com as informações atualizadas
    public User updateUser(Long id, User obj) {
        User entity = repository.getReferenceById(id);
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());

        return repository.save(entity);
    }
}