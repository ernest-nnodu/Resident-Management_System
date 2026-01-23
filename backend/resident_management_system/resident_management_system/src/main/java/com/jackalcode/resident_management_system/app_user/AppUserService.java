package com.jackalcode.resident_management_system.app_user;

import com.jackalcode.resident_management_system.app_user.dto.AppUserSummaryResponse;

import java.util.List;

public interface AppUserService {

    List<AppUserSummaryResponse> getUsers();
}
