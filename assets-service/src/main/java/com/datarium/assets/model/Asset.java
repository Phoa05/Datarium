package com.datarium.assets.model;

import com.datarium.assets.enums.AssetType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String ticker;

    @Enumerated(EnumType.STRING)
    private AssetType type;

    private Double riskLevel;
    private Double expectedReturn;
    private Integer liquidityDays;
}
