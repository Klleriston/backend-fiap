package com.fiap.backend.controllers;

import com.fiap.backend.models.HealthTracking;
import com.fiap.backend.services.HealthTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/healthtrackings")
public class HealthTrackingController {

    @Autowired
    private HealthTrackingService healthTrackingService;

    @PostMapping
    public ResponseEntity<HealthTracking> createHealthTracking(@RequestBody HealthTracking healthTracking) {
        HealthTracking newTracking = healthTrackingService.createHealthTracking(healthTracking.getDate(), healthTracking.getWeight(),
                healthTracking.getWaterIntake(), healthTracking.getUser().getId());
        return new ResponseEntity<>(newTracking, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<HealthTracking>> getAllHealthTrackingsForUser(@PathVariable UUID userId) {
        List<HealthTracking> trackings = healthTrackingService.getAllHealthTrackingsForUser(userId);
        return new ResponseEntity<>(trackings, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HealthTracking> updateHealthTracking(@PathVariable UUID id, @RequestBody HealthTracking healthTracking) {
        HealthTracking updatedTracking = healthTrackingService.updateHealthTracking(id, healthTracking.getDate(), healthTracking.getWeight(),
                healthTracking.getWaterIntake());
        return new ResponseEntity<>(updatedTracking, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHealthTracking(@PathVariable UUID id) {
        healthTrackingService.deleteHealthTracking(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
