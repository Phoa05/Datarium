package com.datarium.recommendation.dto;

import lombok.Data;

@Data
public class AssetDTO {
    private Long id;

    private String name;
    private String ticker;

    private String type;

    private Double riskLevel;
    private Double expectedReturn;
    private Integer liquidityDays;
}
