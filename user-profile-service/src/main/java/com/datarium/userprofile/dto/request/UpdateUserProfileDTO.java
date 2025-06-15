package com.datarium.userprofile.dto.request;

import com.datarium.userprofile.enums.RiskProfile;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

public record UpdateUserProfileDTO(
       @Id Long id,
       String name,
       String email,
       RiskProfile riskProfile,
       Double investmentAmount,
       LocalDateTime updatedAt
) {}
