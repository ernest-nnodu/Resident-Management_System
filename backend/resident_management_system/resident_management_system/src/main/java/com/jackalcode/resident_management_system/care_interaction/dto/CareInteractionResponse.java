package com.jackalcode.resident_management_system.care_interaction.dto;

import com.jackalcode.resident_management_system.care_interaction.CareInteractionType;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

public record CareInteractionResponse(

        UUID id,

        UUID residentId,

        CareInteractionType type,

        String description,

        LocalDate recordedOn,

        Instant recordedAt
) {
}
