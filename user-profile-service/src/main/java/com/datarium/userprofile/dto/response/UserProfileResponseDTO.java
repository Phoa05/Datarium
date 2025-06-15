package com.datarium.userprofile.dto.response;

import com.datarium.userprofile.enums.RiskProfile;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

public record UserProfileResponseDTO(
        @Id Long id,
        String name,
        RiskProfile riskProfile,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
