package com.datarium.recommendation.dto;

import lombok.Data;

@Data
public class UserProfileDTO {
    private String name;
    private String email;
    private String riskProfile;
    private Double investmentAmount;
}
