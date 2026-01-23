package com.jackalcode.resident_management_system.app_user;

import com.jackalcode.resident_management_system.app_user.dto.AppUserResponse;
import com.jackalcode.resident_management_system.app_user.dto.AppUserSummaryResponse;
import com.jackalcode.resident_management_system.app_user.dto.CreateAppUserRequest;

import java.util.List;
import java.util.UUID;

public interface AppUserService {

    List<AppUserSummaryResponse> getUsers();

    AppUserResponse createUser(CreateAppUserRequest request);

    AppUserResponse getUserById(UUID userId);
}
