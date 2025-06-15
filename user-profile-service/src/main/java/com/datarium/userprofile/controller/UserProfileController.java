package com.datarium.userprofile.controller;

import com.datarium.userprofile.dto.request.CreateUserProfileDTO;
import com.datarium.userprofile.dto.request.UpdateUserProfileDTO;
import com.datarium.userprofile.dto.response.UserProfileResponseDTO;
import com.datarium.userprofile.service.UserProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user-profiles")
@RequiredArgsConstructor
@Tag(name = "User Profile", description = "API para gerenciamento de perfis de usuários")
public class UserProfileController {

    private final UserProfileService userProfileService;

    @PostMapping
    @Operation(summary = "Cria um novo perfil de usuário")
    public ResponseEntity<UserProfileResponseDTO> createUserProfile(
            @RequestBody @Valid CreateUserProfileDTO request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userProfileService.createUserProfile(request));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtém um perfil pelo ID")
    public ResponseEntity<UserProfileResponseDTO> getUserProfileById(
            @PathVariable Long id) {
        return ResponseEntity.ok(userProfileService.getUserProfileById(id));
    }

    @GetMapping
    @Operation(summary = "Lista todos os perfis")
    public ResponseEntity<List<UserProfileResponseDTO>> getAllUserProfiles() {
        return ResponseEntity.ok(userProfileService.getAllUserProfiles());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um perfil existente")
    public ResponseEntity<UserProfileResponseDTO> updateUserProfile(
            @PathVariable Long id,
            @RequestBody @Valid UpdateUserProfileDTO request) {
        return ResponseEntity.ok(userProfileService.updateUserProfile(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove um perfil")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserProfile(@PathVariable Long id) {
        userProfileService.deleteUserProfile(id);
    }
}