package com.fiap.backend.repositories;

import com.fiap.backend.models.WeatherNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface WeatherNotificationRepository extends JpaRepository<WeatherNotification, UUID> {
    List<WeatherNotification> findByUserId(UUID userId);
}
