package com.cartaxo.users_crud.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity // Determina que esta classe é uma entidade no nosso banco
@Table(name="tb_user")
public class User {

    @Id // Determina que o atributo a seguir é a chave primária da entidade
    @GeneratedValue(strategy = GenerationType.AUTO) // E como essa chave será gerada
    private Long id;
    private String name;
    private String email;

    public User() { // O construtor vazio é obrigatório para o Spring Boot
    }

    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}