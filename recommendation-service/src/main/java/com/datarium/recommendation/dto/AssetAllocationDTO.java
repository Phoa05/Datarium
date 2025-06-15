package com.datarium.recommendation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssetAllocationDTO {
    private Long assetId;
    private String assetName;
    private double percentage;
    private String reason;
}
