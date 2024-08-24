package com.fiap.backend.models;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.UUID;

@Getter
@Entity
@Table(name = "weather_notification")
public class WeatherNotification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final UUID id;

    @Column(nullable = false)
    private final double temperature;

    @Column(nullable = false)
    private final String message;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public WeatherNotification(double temperature, String message, User user) {
        this.id = UUID.randomUUID();
        this.temperature = temperature;
        this.message = message;
        this.user = user;
    }

    public WeatherNotification() {
        this.id = null;
        this.temperature = 0;
        this.message = "";
        this.user = null;
    }

}
