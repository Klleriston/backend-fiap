package com.fiap.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = true)
    private String fcmToken;

    public User(UUID id, String name, String email, String password, String fcmToken) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.fcmToken = fcmToken;
    }

    public User(String name, String email, String password, String fcmToken) {
        this(UUID.randomUUID(), name, email, password, fcmToken);
    }

    protected User() {
    }
}
