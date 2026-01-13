package com.jackalcode.resident_management_system.resident.dto;

import com.jackalcode.resident_management_system.resident.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CreateResidentRequest(
        @NotBlank(message = "First name is required") String firstName,
        @NotBlank(message = "Last name is required") String lastName,
        @NotNull(message = "Date of Birth is required") LocalDate dateOfBirth,
        @NotNull(message = "Gender is required") Gender gender,
        @NotBlank(message = "Address is required") String address,
        String primaryPhoneNumber,
        String nhsNumber,
        @NotBlank(message = "Allergies are required") String allergies
) {
}
