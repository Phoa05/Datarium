package com.datarium.userprofile.model;

import com.datarium.userprofile.enums.RiskProfile;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @Enumerated(EnumType.STRING)
    private RiskProfile riskProfile;

    private Double investmentAmount;
}
