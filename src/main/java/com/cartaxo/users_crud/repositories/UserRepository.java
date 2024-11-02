package com.cartaxo.users_crud.repositories;

import com.cartaxo.users_crud.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}