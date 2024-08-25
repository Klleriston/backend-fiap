package com.fiap.backend.controllers;

import com.fiap.backend.models.WeatherNotification;
import com.fiap.backend.services.WeatherNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/weathernotifications")
public class WeatherNotificationController {

    @Autowired
    private WeatherNotificationService weatherNotificationService;

    @PostMapping
    public ResponseEntity<WeatherNotification> createWeatherNotification(@RequestBody WeatherNotification weatherNotification) {
        WeatherNotification newNotification = weatherNotificationService.createWeatherNotification(
                weatherNotification.getTemperature(), weatherNotification.getMessage(), weatherNotification.getUser().getId());
        return new ResponseEntity<>(newNotification, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<WeatherNotification>> getWeatherNotificationsForUser(@PathVariable UUID userId) {
        List<WeatherNotification> notifications = weatherNotificationService.getWeatherNotificationsForUser(userId);
        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWeatherNotification(@PathVariable UUID id) {
        weatherNotificationService.deleteWeatherNotification(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
