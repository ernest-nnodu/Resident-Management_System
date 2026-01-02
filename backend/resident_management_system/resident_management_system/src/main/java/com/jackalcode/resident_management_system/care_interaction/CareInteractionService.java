package com.jackalcode.resident_management_system.care_interaction;

import com.jackalcode.resident_management_system.care_interaction.dto.CareInteractionResponse;
import com.jackalcode.resident_management_system.care_interaction.dto.CreateCareInteractionRequest;
import com.jackalcode.resident_management_system.care_interaction.dto.UpdateCareInteractionRequest;

import java.util.List;
import java.util.UUID;

public interface CareInteractionService {

    List<CareInteractionResponse> getCareInteractions(UUID residentId);
    CareInteractionResponse createCareInteraction(UUID residentId, CreateCareInteractionRequest request);
    CareInteractionResponse getCareInteraction(UUID careInteractionId);
    CareInteractionResponse updateCareInteraction(UUID careInteractionId, UpdateCareInteractionRequest request);
    void deleteCareInteraction(UUID careInteractionId);
}
