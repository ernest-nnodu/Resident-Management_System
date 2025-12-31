package com.jackalcode.resident_management_system.care_interaction;

import com.jackalcode.resident_management_system.care_interaction.dto.CareInteractionResponse;
import com.jackalcode.resident_management_system.care_interaction.dto.CreateCareInteractionRequest;

import java.util.List;
import java.util.UUID;

public interface CareInteractionService {

    List<CareInteractionResponse> getCareInteractions(UUID residentId);
    CareInteractionResponse createCareInteraction(UUID residentId, CreateCareInteractionRequest request);
}
