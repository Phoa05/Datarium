package com.datarium.userprofile.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

@Schema(description = "DTO para criação de perfil de usuário")
public record CreateUserProfileDTO(
        @NotBlank(message = "{validation.name.required}")
        @Size(min = 3, max = 100, message = "{validation.name.size}")
        String name,

        @NotBlank(message = "{validation.email.required}")
        @Email(message = "{validation.email.invalid}")
        String email,

        String riskProfile,

        @NotNull(message = "{validation.investment.required}")
        @PositiveOrZero(message = "{validation.investment.positive}")
        Double investmentAmount
) {}