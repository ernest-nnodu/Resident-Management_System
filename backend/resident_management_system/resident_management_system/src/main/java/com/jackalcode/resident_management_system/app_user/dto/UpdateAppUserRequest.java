package com.jackalcode.resident_management_system.app_user.dto;

import com.jackalcode.resident_management_system.app_user.UserRole;

public record UpdateAppUserRequest(
        String firstName,
        String lastName,
        UserRole role,
        Boolean enabled,
        Boolean accountNonLocked
) {
}
