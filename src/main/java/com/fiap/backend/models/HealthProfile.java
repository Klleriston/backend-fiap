package com.fiap.backend.models;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.UUID;

@Entity
@Table(name = "health_profiles")
public class HealthProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final UUID id;

    @Column(nullable = false)
    private final double weight;

    @Column(nullable = false)
    private final double height;

    @Column(nullable = false)
    private final String activityLevel;

    @Column(nullable = false)
    private final boolean mobilityIssues;

    @Getter
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public HealthProfile(double weight, double height, String activityLevel, boolean mobilityIssues, User user) {
        this.id = UUID.randomUUID();
        this.weight = weight;
        this.height = height;
        this.activityLevel = activityLevel;
        this.mobilityIssues = mobilityIssues;
        this.user = user;
    }

    public HealthProfile() {
        this.id = null;
        this.weight = 0;
        this.height = 0;
        this.activityLevel = null;
        this.mobilityIssues = false;
        this.user = null;
    }
}