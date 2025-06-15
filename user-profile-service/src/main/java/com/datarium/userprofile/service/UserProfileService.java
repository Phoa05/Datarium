package com.datarium.userprofile.service;

import com.datarium.userprofile.dto.request.CreateUserProfileDTO;
import com.datarium.userprofile.dto.request.UpdateUserProfileDTO;
import com.datarium.userprofile.dto.response.UserProfileResponseDTO;

import java.util.List;

public interface UserProfileService {
    UserProfileResponseDTO createUserProfile(CreateUserProfileDTO request);
    UserProfileResponseDTO getUserProfileById(Long id);
    List<UserProfileResponseDTO> getAllUserProfiles();
    UserProfileResponseDTO updateUserProfile(Long id, UpdateUserProfileDTO request);
    void deleteUserProfile(Long id);
}
