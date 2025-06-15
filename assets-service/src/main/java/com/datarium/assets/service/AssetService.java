package com.datarium.assets.service;

import com.datarium.assets.dto.AssetRequestDTO;
import com.datarium.assets.dto.AssetResponseDTO;
import com.datarium.assets.model.Asset;
import com.datarium.assets.repository.AssetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class AssetService {
    private final AssetRepository repository;

    public AssetResponseDTO createAsset(AssetRequestDTO dto) {
        Asset asset = new Asset();
        asset.setName(dto.getName());
        asset.setTicker(dto.getTicker());
        asset.setType(dto.getType());
        asset.setRiskLevel(dto.getRiskLevel());
        asset.setExpectedReturn(dto.getExpectedReturn());
        asset.setLiquidityDays(dto.getLiquidityDays());

        Asset savedAsset = repository.save(asset);
        return convertToDTO(savedAsset);
    }

    public List<AssetResponseDTO> getAllAssets() {
        return (List<AssetResponseDTO>)repository.findAll().stream()
                .map(this::convertToDTO);
    }

    private AssetResponseDTO convertToDTO(Asset asset) {
        return new AssetResponseDTO(
                asset.getId(),
                asset.getName(),
                asset.getTicker(),
                asset.getType(),
                asset.getRiskLevel(),
                asset.getExpectedReturn(),
                asset.getLiquidityDays()
        );
    }
}
