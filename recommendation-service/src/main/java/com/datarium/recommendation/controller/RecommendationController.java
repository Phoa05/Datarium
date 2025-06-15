package com.datarium.recommendation.controller;

import com.datarium.recommendation.dto.RecommendationRequestDTO;
import com.datarium.recommendation.dto.RecommendationResponseDTO;
import com.datarium.recommendation.engine.RecommendationEngine;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recommendations")
@Tag(name = "Recommendations", description = "Geração de recomendações de investimento")
public class RecommendationController {
    private final RecommendationEngine engine;

    public RecommendationController(RecommendationEngine engine) {
        this.engine = engine;
    }

    @PostMapping
    @Operation(summary = "Gera recomendações personalizadas")
    public RecommendationResponseDTO generateRecommendation(
            @RequestBody RecommendationRequestDTO request) {
        return engine.generateRecommendation(request);
    }

    @GetMapping("/quick/{userId}")
    @Operation(summary = "Recomendação rápida baseada apenas no perfil")
    public RecommendationResponseDTO quickRecommendation(
            @PathVariable Long userId) {
        return engine.generateRecommendation(
                new RecommendationRequestDTO(userId, "GENERAL", 60));
    }
}