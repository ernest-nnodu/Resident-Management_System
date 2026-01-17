package com.jackalcode.resident_management_system.care_interaction.dto;

import com.jackalcode.resident_management_system.care_interaction.CareInteractionType;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Update care interaction DTO")
public record UpdateCareInteractionRequest(

        @Schema(description = "Care interaction type")
        CareInteractionType type,

        @Schema(description = "Care interaction description")
        String description
) {
}
