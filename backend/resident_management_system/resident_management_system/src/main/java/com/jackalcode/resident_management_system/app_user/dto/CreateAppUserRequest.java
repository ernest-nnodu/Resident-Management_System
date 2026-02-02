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
        @NotBlank(message = "Email is required")
        @Email(message = "Email format invalid")
        String email,

        @Schema(description = "User password")
        @NotBlank(message = "Password is required")
        @Size(min = 8, message = "Password should contain min 8 characters")
        String password,

        @Schema(description = "User first name")
        @NotBlank(message = "First name is required")
        String firstName,

        @Schema(description = "User last name")
        @NotBlank(message = "Last name is required")
        String lastName,

        @Schema(description = "User role")
        @NotNull(message = "User role is required")
        UserRole role
) {
}
