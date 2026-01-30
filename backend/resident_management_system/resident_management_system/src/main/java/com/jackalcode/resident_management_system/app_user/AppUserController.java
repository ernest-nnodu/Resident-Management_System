package com.jackalcode.resident_management_system.app_user;

import com.jackalcode.resident_management_system.app_user.dto.AppUserSummaryResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class AppUserController {

    private final AppUserService appUserService;

    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping
    public ResponseEntity<List<AppUserSummaryResponse>> getUsers() {

        List<AppUserSummaryResponse> userSummaryResponseList = appUserService.getUsers();

        return new ResponseEntity<>(userSummaryResponseList, HttpStatus.OK);
    }
}
