package com.datarium.recommendation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecommendationRequestDTO {
    private Long userId;
    private String investmentGoal;
    private Integer timeHorizonMonths;
}
