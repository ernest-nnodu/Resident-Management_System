package com.jackalcode.resident_management_system.resident.dto;

import com.jackalcode.resident_management_system.resident.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record UpdateResidentRequest(
        @NotBlank String firstName,
        @NotBlank String lastName,
        @NotNull LocalDate dateOfBirth,
        @NotNull Gender gender,
        @NotBlank String address,
        @NotNull LocalDate admissionDate,
        String primaryPhoneNumber,
        String nhsNumber,
        @NotBlank String allergies
) {
}
