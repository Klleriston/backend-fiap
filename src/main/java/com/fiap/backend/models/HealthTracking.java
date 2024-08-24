package com.fiap.backend.models;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name= "health_tracking")
public class HealthTracking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final UUID id;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private final Date date;

    @Column(nullable = false)
    private final double weight;

    @Column(nullable = false)
    private final double waterIntake;

    @Getter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public HealthTracking(UUID id, Date date, double weight, double waterIntake, User user) {
        this.id = id;
        this.date = date;
        this.weight = weight;
        this.waterIntake = waterIntake;
        this.user = user;
    }

    public HealthTracking() {
        this.id = null;
        this.date = null;
        this.weight = 0.0;
        this.waterIntake = 0.0;
        this.user = null;
    }
}
