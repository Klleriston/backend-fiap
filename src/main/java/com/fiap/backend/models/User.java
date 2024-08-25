package com.fiap.backend.models;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.UUID;

@Getter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final UUID id;

    @Column(nullable = false)
    private final String name;

    @Column(nullable = false, unique = true)
    private final String email;

    @Column(nullable = false)
    private final String password;

    public User(UUID id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(String name, String email, String password) {
        this(UUID.randomUUID(), name, email, password);
    }

    protected User() {
        this.id = null;
        this.name = null;
        this.email = null;
        this.password = null;
    }
}
