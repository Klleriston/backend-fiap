package com.fiap.backend.repositories;

import com.fiap.backend.models.HealthProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface HealthProfileRepository extends JpaRepository<HealthProfile, UUID> {
    Optional<HealthProfile> findByUserId(UUID userId);
}
