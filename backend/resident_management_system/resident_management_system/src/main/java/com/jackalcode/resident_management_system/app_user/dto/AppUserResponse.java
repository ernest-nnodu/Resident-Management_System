package com.jackalcode.resident_management_system.app_user.dto;

import com.jackalcode.resident_management_system.app_user.UserRole;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.Instant;
import java.util.UUID;

@Schema(description = "App user response DTO")
public record AppUserResponse(

        @Schema(description = "App user ID")
        UUID id,

        @Schema(description = "App user email address")
        String email,

        @Schema(description = "App user first name")
        String firstName,

        @Schema(description = "App user last name")
        String lastName,

        @Schema(description = "App user role")
        UserRole role,

        @Schema(description = "App user account enabled status")
        boolean enabled,

        @Schema(description = "App user account locked status")
        boolean accountNonLocked,

        @Schema(description = "App user creation time")
        Instant createdAt,

        @Schema(description = "App user last login time")
        Instant lastLoginAt
) {
}
