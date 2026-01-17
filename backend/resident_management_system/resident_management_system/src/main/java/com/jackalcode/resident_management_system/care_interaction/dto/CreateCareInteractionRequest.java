package com.jackalcode.resident_management_system.care_interaction.dto;

import com.jackalcode.resident_management_system.care_interaction.CareInteractionType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Create care interaction DTO")
public record CreateCareInteractionRequest(

        @Schema(description = "Care interaction type")
        @NotNull(message = "Care interation type is required")
        CareInteractionType type,

        @Schema(description = "Care interaction description")
        @NotBlank(message = "Description should not be empty or blank")
        String description
) {
}
