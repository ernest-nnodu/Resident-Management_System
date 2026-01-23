package com.jackalcode.resident_management_system.app_user.dto;

import com.jackalcode.resident_management_system.app_user.UserRole;

import java.util.UUID;

public record AppUserSummaryResponse(
        UUID id,
        String email,
        String firstName,
        String lastName,
        UserRole role,
        boolean enabled
) {
}
