package com.jackalcode.resident_management_system.app_user;

import com.jackalcode.resident_management_system.app_user.dto.AppUserResponse;
import com.jackalcode.resident_management_system.app_user.dto.AppUserSummaryResponse;
import com.jackalcode.resident_management_system.app_user.dto.CreateAppUserRequest;
import com.jackalcode.resident_management_system.app_user.dto.UpdateAppUserRequest;
import com.jackalcode.resident_management_system.exception.AppUserAlreadyExistsException;
import com.jackalcode.resident_management_system.exception.AppUserNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository userRepository;
    private final ModelMapper mapper;

    public AppUserServiceImpl(AppUserRepository userRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public List<AppUserSummaryResponse> getUsers() {

        List<AppUser> users = userRepository.findAll();

        return users.stream()
                .map(this::mapToSummaryResponse)
                .toList();
    }

    @Override
    public AppUserResponse createUser(CreateAppUserRequest request) {

        if (userRepository.existsByEmailIgnoreCase(request.email())) {
            throw new AppUserAlreadyExistsException(
                    "User already exists with email: " + request.email()
            );
        }

        AppUser user = mapToUserEntity(request);

        AppUser savedUser = userRepository.save(user);

        return mapToResponse(savedUser);
    }

    @Override
    public AppUserResponse getUserById(UUID userId) {

        AppUser user = getUserEntity(userId);
        return mapToResponse(user);
    }

    @Override
    public AppUserResponse updateUser(UUID userId, UpdateAppUserRequest request) {

        AppUser existingUser = getUserEntity(userId);
        mapper.map(request, existingUser);

        return mapToResponse(userRepository.save(existingUser));
    }

    @Override
    public void disableUser(UUID userId) {

        AppUser user = getUserEntity(userId);
        user.setEnabled(false);
    }

    private AppUser getUserEntity(UUID userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new AppUserNotFoundException(
                        "User not found with id: " + userId
                ));
    }

    private AppUser mapToUserEntity(CreateAppUserRequest request) {
        return AppUser.builder()
                .email(request.email().toLowerCase())
                .password(request.password())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .role(request.role())
                .enabled(true)
                .accountNonLocked(true)
                .failedLoginAttempts(0)
                .build();
    }

    private AppUserResponse mapToResponse(AppUser user) {

        return new AppUserResponse(
                user.getId(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getRole(),
                user.isEnabled(),
                user.isAccountNonLocked(),
                user.getCreatedAt(),
                user.getLastLoginAt()
        );
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
