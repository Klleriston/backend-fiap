package com.fiap.backend.services;

import com.fiap.backend.exceptions.ResourceNotFoundException;
import com.fiap.backend.models.User;
import com.fiap.backend.models.WeatherNotification;
import com.fiap.backend.repositories.UserRepository;
import com.fiap.backend.repositories.WeatherNotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WeatherNotificationService {

    @Autowired
    private WeatherNotificationRepository weatherNotificationRepository;

    @Autowired
    private UserRepository userRepository;

    public WeatherNotification createWeatherNotification(double temperature, String message, UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        WeatherNotification weatherNotification = new WeatherNotification(temperature, message, user);
        return weatherNotificationRepository.save(weatherNotification);
    }

    public WeatherNotification getWeatherNotificationById(UUID id) {
        return weatherNotificationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("WeatherNotification not found with id: " + id));
    }

    public List<WeatherNotification> getWeatherNotificationsForUser(UUID userId) {
        return weatherNotificationRepository.findByUserId(userId);
    }

    public void deleteWeatherNotification(UUID id) {
        WeatherNotification weatherNotification = weatherNotificationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("WeatherNotification not found with id: " + id));
        weatherNotificationRepository.delete(weatherNotification);
    }
}
