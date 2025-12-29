package com.jackalcode.resident_management_system.care_interaction.dto;

import com.jackalcode.resident_management_system.care_interaction.CareInteractionType;

public record UpdateCareInteractionRequest(

        CareInteractionType type,

        String description
) {
}
