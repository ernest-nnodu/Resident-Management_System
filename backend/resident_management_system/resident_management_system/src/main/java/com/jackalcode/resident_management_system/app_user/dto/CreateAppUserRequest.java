package com.jackalcode.resident_management_system.app_user.dto;

import com.jackalcode.resident_management_system.app_user.UserRole;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Schema(description = "Create app user request DTO")
public record CreateAppUserRequest(

        @Schema(description = "User email address")
        @NotBlank
        @Email
        String email,

        @Schema(description = "User password")
        @NotBlank
        @Size(min = 8)
        String password,

        @Schema(description = "User first name")
        @NotBlank
        String firstName,

        @Schema(description = "User last name")
        @NotBlank
        String lastName,

        @Schema(description = "User role")
        @NotNull
        UserRole role
) {
}
