package com.jackalcode.resident_management_system.app_user;

import com.jackalcode.resident_management_system.app_user.dto.AppUserSummaryResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository userRepository;

    public AppUserServiceImpl(AppUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<AppUserSummaryResponse> getUsers() {

        List<AppUser> users = userRepository.findAll();

        return users.stream()
                .map(this::mapToSummaryResponse)
                .toList();
    }

    private AppUserSummaryResponse mapToSummaryResponse(AppUser user) {

        return new AppUserSummaryResponse(
                user.getId(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getRole(),
                user.isEnabled()
        );

    }
}
