package com.datarium.recommendation.feign;

import com.datarium.recommendation.dto.AssetDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "assets-service", url = "${services.assets.url}")
public interface AssetsServiceClient {
    @GetMapping("/api/assets")
    List<AssetDTO> getAllAssets();
}