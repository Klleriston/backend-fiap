package com.fiap.backend.repositories;

import com.fiap.backend.models.HealthTracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface HealthTrackingRepository extends JpaRepository<HealthTracking, UUID> {
    List<HealthTracking> findByUserId(UUID id);
}
