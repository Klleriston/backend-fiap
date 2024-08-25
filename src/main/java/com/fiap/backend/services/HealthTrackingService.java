package com.fiap.backend.services;

import com.fiap.backend.exceptions.ResourceNotFoundException;
import com.fiap.backend.models.HealthTracking;
import com.fiap.backend.models.User;
import com.fiap.backend.repositories.HealthTrackingRepository;
import com.fiap.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class HealthTrackingService {

    @Autowired
    private HealthTrackingRepository healthTrackingRepository;

    @Autowired
    private UserRepository userRepository;

    public HealthTracking createHealthTracking(Date date, double weight, double waterIntake, UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        HealthTracking healthTracking = new HealthTracking(UUID.randomUUID(), date, weight, waterIntake, user);
        return healthTrackingRepository.save(healthTracking);
    }

    public HealthTracking updateHealthTracking(UUID id, Date date, double weight, double waterIntake) {
        HealthTracking existingTracking = healthTrackingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("HealthTracking not found with id: " + id));

        existingTracking.setDate(date);
        existingTracking.setWeight(weight);
        existingTracking.setWaterIntake(waterIntake);

        return healthTrackingRepository.save(existingTracking);
    }

    public HealthTracking getHealthTrackingById(UUID id) {
        return healthTrackingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("HealthTracking not found with id: " + id));
    }

    public List<HealthTracking> getAllHealthTrackingsForUser(UUID userId) {
        return healthTrackingRepository.findByUserId(userId);
    }

    public void deleteHealthTracking(UUID id) {
        HealthTracking healthTracking = healthTrackingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("HealthTracking not found with id: " + id));
        healthTrackingRepository.delete(healthTracking);
    }
}
