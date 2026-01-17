package com.jackalcode.resident_management_system.resident.dto;

import com.jackalcode.resident_management_system.resident.Gender;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

@Schema(description = "Resident response DTO")
public record ResidentResponse(
        @Schema(description = "Resident ID")
        UUID id,

        @Schema(description = "Resident first name")
        String firstName,

        @Schema(description = "Resident last name")
        String lastName,

        @Schema(description = "Resident date of birth")
        LocalDate dateOfBirth,

        @Schema(description = "Resident gender")
        Gender gender,

        @Schema(description = "Resident address")
        String address,

        @Schema(description = "Resident admission date")
        LocalDate admissionDate,

        @Schema(description = "Resident phone number")
        String primaryPhoneNumber,

        @Schema(description = "Resident NHS number")
        String nhsNumber,

        @Schema(description = "Resident allergies")
        String allergies
) {
}
