package com.datarium.userprofile.service.impl;

import com.datarium.userprofile.dto.request.CreateUserProfileDTO;
import com.datarium.userprofile.dto.request.UpdateUserProfileDTO;
import com.datarium.userprofile.dto.response.UserProfileResponseDTO;
import com.datarium.userprofile.exception.ResourceNotFoundException;
import com.datarium.userprofile.mapper.UserProfileMapper;
import com.datarium.userprofile.model.UserProfile;
import com.datarium.userprofile.repository.UserProfileRepository;
import com.datarium.userprofile.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;
    private final UserProfileMapper userProfileMapper;

    @Override
    @Transactional
    public UserProfileResponseDTO createUserProfile(CreateUserProfileDTO request) {
        UserProfile userProfile = userProfileMapper.toEntity(request);
        UserProfile savedProfile = userProfileRepository.save(userProfile);
        return userProfileMapper.toDTO(savedProfile);
    }

    @Override
    @Transactional(readOnly = true)
    public UserProfileResponseDTO getUserProfileById(Long id) {
        return userProfileRepository.findById(id)
                .map(userProfileMapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("UserProfile not found with id: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserProfileResponseDTO> getAllUserProfiles() {
        return userProfileRepository.findAll()
                .stream()
                .map(userProfileMapper::toDTO)
                .toList();
    }

    @Override
    @Transactional
    public UserProfileResponseDTO updateUserProfile(Long id, UpdateUserProfileDTO request) {
        return userProfileRepository.findById(id)
                .map(profile -> {
                    userProfileMapper.updateUserProfileFromDTO(request, profile);
                    UserProfile updatedProfile = userProfileRepository.save(profile);
                    return userProfileMapper.toDTO(updatedProfile);
                })
                .orElseThrow(() -> new ResourceNotFoundException("UserProfile not found with id: " + id));
    }

    @Override
    @Transactional
    public void deleteUserProfile(Long id) {
        if (!userProfileRepository.existsById(id)) {
            throw new ResourceNotFoundException("UserProfile not found with id: " + id);
        }
        userProfileRepository.deleteById(id);
    }
}