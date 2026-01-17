package com.jackalcode.resident_management_system.resident.dto;

import com.jackalcode.resident_management_system.resident.Gender;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Schema(description = "Update resident DTO")
public record UpdateResidentRequest(
        @Schema(description = "Resident first name")
        @NotBlank(message = "First name is required")
        String firstName,

        @Schema(description = "Resident last name")
        @NotBlank(message = "Last name is required")
        String lastName,

        @Schema(description = "Resident date of birth")
        @NotNull(message = "Date of Birth is required")
        LocalDate dateOfBirth,

        @Schema(description = "Resident gender")
        @NotNull(message = "Gender is required")
        Gender gender,

        @Schema(description = "Resident address")
        @NotBlank(message = "Address is required")
        String address,

        @Schema(description = "Resident phone number")
        String primaryPhoneNumber,

        @Schema(description = "Resident NHS number")
        String nhsNumber,

        @Schema(description = "Resident allergies")
        @NotBlank(message = "Allergies are required")
        String allergies
) {
}
