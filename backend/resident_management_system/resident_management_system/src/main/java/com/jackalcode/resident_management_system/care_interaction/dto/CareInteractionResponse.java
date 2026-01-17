package com.jackalcode.resident_management_system.care_interaction.dto;

import com.jackalcode.resident_management_system.care_interaction.CareInteractionType;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Schema(description = "Care interaction response DTO")
public record CareInteractionResponse(

        @Schema(description = "Care interaction ID")
        UUID id,

        @Schema(description = "Care interaction resident ID")
        UUID residentId,

        @Schema(description = "Care interaction type")
        CareInteractionType type,

        @Schema(description = "Care Interaction description")
        String description,

        @Schema(description = "Care interaction record date")
        LocalDate recordedOn,

        @Schema(description = "Care interaction record time")
        Instant recordedAt
) {
}
