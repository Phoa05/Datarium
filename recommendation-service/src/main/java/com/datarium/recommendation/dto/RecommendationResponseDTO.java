package com.datarium.recommendation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class RecommendationResponseDTO {
    private String riskLevel;
    private String recommendationStrategy;
    private List<AssetAllocationDTO> allocations;
    private String explanation;
}
