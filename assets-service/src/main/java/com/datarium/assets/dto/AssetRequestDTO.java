package com.datarium.assets.dto;

import com.datarium.assets.enums.AssetType;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@AllArgsConstructor
public class AssetRequestDTO {
    @NotBlank
    private String name;

    @NotBlank
    private String ticker;

    @NotNull
    private AssetType type;

    @DecimalMin("0.1")
    @DecimalMax("10.0")
    private Double riskLevel;

    @PositiveOrZero
    private Double expectedReturn;

    @Min(1)
    private Integer liquidityDays;
}
