package com.fiap.backend.controllers;

import com.fiap.backend.models.HealthProfile;
import com.fiap.backend.services.HealthProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/healthprofiles")
public class HealthProfileController {

    @Autowired
    private HealthProfileService healthProfileService;

    @GetMapping("/{userId}")
    public ResponseEntity<HealthProfile> getHealthProfileByUserId(@PathVariable UUID userId) {
        HealthProfile healthProfile = healthProfileService.getHealthProfileByUserId(userId);
        return new ResponseEntity<>(healthProfile, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HealthProfile> updateHealthProfile(@PathVariable UUID id, @RequestBody HealthProfile healthProfile) {
        HealthProfile updatedProfile = healthProfileService.updateHealthProfile(id, healthProfile.getWeight(), healthProfile.getHeight(),
                healthProfile.getActivityLevel(), healthProfile.isMobilityIssues());
        return new ResponseEntity<>(updatedProfile, HttpStatus.OK);
    }
}
