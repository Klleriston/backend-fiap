package com.fiap.backend.services;

import com.fiap.backend.exceptions.ResourceNotFoundException;
import com.fiap.backend.models.HealthProfile;
import com.fiap.backend.models.User;
import com.fiap.backend.repositories.HealthProfileRepository;
import com.fiap.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class HealthProfileService {

    @Autowired
    private HealthProfileRepository healthProfileRepository;

    @Autowired
    private UserRepository userRepository;

    public HealthProfile createHealthProfile(double weight, double height, String activityLevel, boolean mobilityIssues, UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        HealthProfile healthProfile = new HealthProfile(weight, height, activityLevel, mobilityIssues, user);
        return healthProfileRepository.save(healthProfile);
    }

    public HealthProfile updateHealthProfile(UUID id, double weight, double height, String activityLevel, boolean mobilityIssues) {
        HealthProfile existingProfile = healthProfileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("HealthProfile not found with id: " + id));

        existingProfile.setWeight(weight);
        existingProfile.setHeight(height);
        existingProfile.setActivityLevel(activityLevel);
        existingProfile.setMobilityIssues(mobilityIssues);

        return healthProfileRepository.save(existingProfile);
    }

    public HealthProfile getHealthProfileByUserId(UUID userId) {
        return healthProfileRepository.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("HealthProfile not found for user id: " + userId));
    }

    public void deleteHealthProfile(UUID id) {
        HealthProfile healthProfile = healthProfileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("HealthProfile not found with id: " + id));
        healthProfileRepository.delete(healthProfile);
    }
}
