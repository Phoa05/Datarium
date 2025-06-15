package com.datarium.userprofile.dto.response;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ErrorResponseDTO (
        LocalDateTime errorTime,
        HttpStatus status,
        String message,
        String detailsMessage
){}
