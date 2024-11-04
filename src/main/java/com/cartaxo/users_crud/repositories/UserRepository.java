package com.cartaxo.users_crud.repositories;

import com.cartaxo.users_crud.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

// Interface responsável pelas operações de persistência
public interface UserRepository extends JpaRepository<User, Long> {
}