package com.datarium.assets.controller;

import com.datarium.assets.dto.AssetRequestDTO;
import com.datarium.assets.dto.AssetResponseDTO;
import com.datarium.assets.service.AssetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assets")
@Tag(name = "Assets", description = "Gestão de ativos de investimento")
public class AssetController {
    private final AssetService service;

    public AssetController(AssetService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cria um novo ativo")
    public AssetResponseDTO create(@RequestBody @Valid AssetRequestDTO dto) {
        return service.createAsset(dto);
    }

    @GetMapping
    @Operation(summary = "Lista todos os ativos")
    public List<AssetResponseDTO> getAll() {
        return service.getAllAssets();
    }
}
