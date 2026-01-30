package com.jackalcode.resident_management_system.app_user;

import com.jackalcode.resident_management_system.app_user.dto.AppUserResponse;
import com.jackalcode.resident_management_system.app_user.dto.AppUserSummaryResponse;
import com.jackalcode.resident_management_system.app_user.dto.CreateAppUserRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "App User REST API", description = "Provides CRUD operations for managing app users")
@RestController
@RequestMapping("/api/v1/users")
public class AppUserController {

    private final AppUserService appUserService;

    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @Operation(summary = "Retrieve users", description = "Retrieves all users")
    @ApiResponse(responseCode = "200", description = "Users retrieved successfully")
    @GetMapping
    public ResponseEntity<List<AppUserSummaryResponse>> getUsers() {

        List<AppUserSummaryResponse> userSummaryResponseList = appUserService.getUsers();

        return new ResponseEntity<>(userSummaryResponseList, HttpStatus.OK);
    }

    @Operation(summary = "Create new user", description = "Creates and persist a new user ")
    @ApiResponse(responseCode = "201", description = "User successfully created")
    @PostMapping
    public ResponseEntity<AppUserResponse> createUser(@Valid @RequestBody CreateAppUserRequest request) {

        AppUserResponse userResponse = appUserService.createUser(request);

        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }
}
