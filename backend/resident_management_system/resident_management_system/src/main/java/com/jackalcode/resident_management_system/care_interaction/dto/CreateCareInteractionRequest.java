package com.jackalcode.resident_management_system.care_interaction.dto;

import com.jackalcode.resident_management_system.care_interaction.CareInteractionType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateCareInteractionRequest(

        @NotNull(message = "Care interation type is required")
        CareInteractionType type,

        @NotBlank(message = "Description should not be empty or blank")
        String description
) {
}
