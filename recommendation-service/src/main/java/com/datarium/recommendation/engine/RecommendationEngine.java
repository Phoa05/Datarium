package com.datarium.recommendation.engine;

import com.datarium.recommendation.dto.*;
import com.datarium.recommendation.feign.AssetsServiceClient;
import com.datarium.recommendation.feign.UserProfileServiceClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecommendationEngine {
    private final AssetsServiceClient assetsClient;
    private final UserProfileServiceClient profileClient;

    public RecommendationEngine(AssetsServiceClient assetsClient,
                                UserProfileServiceClient profileClient) {
        this.assetsClient = assetsClient;
        this.profileClient = profileClient;
    }

    public RecommendationResponseDTO generateRecommendation(RecommendationRequestDTO request) {
        UserProfileDTO profile = profileClient.getProfileById(request.getUserId());
        List<AssetDTO> assets = assetsClient.getAllAssets();

        List<AssetDTO> filteredAssets = filterByRiskProfile(assets, profile.getRiskProfile());

        RecommendationResponseDTO recommendation;

        switch (profile.getRiskProfile()){
            case "CONSERVATIVE":
                recommendation = buildConservativePortfolio(filteredAssets, request);
                break;
            case "MODERATE":
                recommendation = buildModeratePortfolio(filteredAssets, request);
                break;
            case "AGGRESSIVE":
                recommendation = buildAggressivePortfolio(filteredAssets, request);
                break;
            default:
                throw new IllegalArgumentException("Perfil de risco inválido");
        }

        return recommendation;
    }

    private List<AssetDTO> filterByRiskProfile(List<AssetDTO> assets, String riskProfile) {
        return assets.stream()
                .filter(asset -> isCompatible(asset.getRiskLevel(), riskProfile))
                .collect(Collectors.toList());
    }

    private boolean isCompatible(double assetRisk, String profileRisk) {
        boolean compatible = false;
        switch (profileRisk){
            case "CONSERVATIVE":
                if (assetRisk <= 4.0){
                    compatible = true;
                }
                break;
            case "MODERATE":
                if (assetRisk <= 7.0){
                    compatible = true;
                }
                break;
            case "AGGRESSIVE":
                compatible = true;
                break;
        }
        return compatible;
    }

    private RecommendationResponseDTO buildConservativePortfolio(List<AssetDTO> assets, RecommendationRequestDTO request) {
        // Lógica simplificada - 70% Renda Fixa, 30% Fundos Conservadores
        List<AssetAllocationDTO> allocations = assets.stream()
                .filter(a -> a.getType().equals("BOND"))
                .limit(3)
                .map(a -> new AssetAllocationDTO(
                        a.getId(),
                        a.getName(),
                        30.0,
                        "Baixo risco compatível com perfil conservador"))
                .collect(Collectors.toList());

        return new RecommendationResponseDTO(
                "CONSERVATIVE",
                "Preservação de Capital",
                allocations,
                "Carteira focada em segurança e liquidez"
        );
    }

    private RecommendationResponseDTO buildModeratePortfolio(List<AssetDTO> assets, RecommendationRequestDTO request) {
        // 50% Renda Fixa, 50% Fundos com mais risco
        List<AssetAllocationDTO> allocations = assets.stream()
                .filter(a -> a.getType().equals("BOND"))
                .limit(3)
                .map(a -> new AssetAllocationDTO(
                        a.getId(),
                        a.getName(),
                        50.0,
                        "Risco moderavel compatível com perfil moderado"))
                .collect(Collectors.toList());

        return new RecommendationResponseDTO(
                "MODERATE",
                "quilíbrio entre risco e rentabilidade",
                allocations,
                "Carteira focada em rentabilicade com risco controlado"
        );
    }

    private RecommendationResponseDTO buildAggressivePortfolio(List<AssetDTO> assets, RecommendationRequestDTO request) {
        // 30% Renda Fixa, 70% Fundos com mais risco
        List<AssetAllocationDTO> allocations = assets.stream()
                .filter(a -> a.getType().equals("BOND"))
                .limit(3)
                .map(a -> new AssetAllocationDTO(
                        a.getId(),
                        a.getName(),
                        70.0,
                        "Risco compatível com perfil agressivo"))
                .collect(Collectors.toList());

        return new RecommendationResponseDTO(
                "AGGRESSIVE",
                "foco em rentabilidade",
                allocations,
                "Carteira focada em maximizar o retorno "
        );
    }
}