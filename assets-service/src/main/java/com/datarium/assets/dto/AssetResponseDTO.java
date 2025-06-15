package com.datarium.assets.dto;

import com.datarium.assets.enums.AssetType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AssetResponseDTO {
    private Long id;
    private String name;
    private String ticker;
    private AssetType type;
    private Double riskLevel;
    private Double expectedReturn;
    private Integer liquidityDays;
}
