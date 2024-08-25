package com.fiap.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "health_tracking")
@Getter
@Setter
public class HealthTracking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(nullable = false)
    private double weight;

    @Column(nullable = false)
    private double waterIntake;

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
        this.id = UUID.randomUUID();
        this.date = new Date();
        this.weight = 0.0;
        this.waterIntake = 0.0;
        this.user = null;
    }
}
