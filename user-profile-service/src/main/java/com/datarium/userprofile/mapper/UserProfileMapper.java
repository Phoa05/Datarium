package com.datarium.userprofile.mapper;

import com.datarium.userprofile.dto.request.CreateUserProfileDTO;
import com.datarium.userprofile.dto.request.UpdateUserProfileDTO;
import com.datarium.userprofile.dto.response.UserProfileResponseDTO;
import com.datarium.userprofile.model.UserProfile;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserProfileMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    UserProfile toEntity(CreateUserProfileDTO dto);

    UserProfileResponseDTO toDTO(UserProfile entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    void updateUserProfileFromDTO(UpdateUserProfileDTO dto, @MappingTarget UserProfile entity);
}