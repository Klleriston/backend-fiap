package com.fiap.backend.models;

import com.fiap.backend.models.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "health_profiles")
@Getter
@Setter
public class HealthProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private double weight;

    @Column(nullable = false)
    private double height;

    @Column(nullable = false)
    private String activityLevel;

    @Column(nullable = false)
    private boolean mobilityIssues;

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
        this.id = UUID.randomUUID();
        this.weight = 0.0;
        this.height = 0.0;
        this.activityLevel = "Inactive";
        this.mobilityIssues = false;
        this.user = null;
    }
}
