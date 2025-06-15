package com.datarium.recommendation.feign;

import com.datarium.recommendation.dto.UserProfileDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-profile-service", url = "${services.user-profile.url}")
public interface UserProfileServiceClient {
    @GetMapping("/api/profiles/{id}")
    UserProfileDTO getProfileById(@PathVariable Long id);
}