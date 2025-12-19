package com.jackalcode.resident_management_system.resident.dto;

import com.jackalcode.resident_management_system.resident.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record ResidentResponse(
        UUID id,
        String firstName,
        String lastName,
        LocalDate dateOfBirth,
        Gender gender,
        String address,
        LocalDate admissionDate,
        String primaryPhoneNumber,
        String nhsNumber,
        String allergies
) {
}
