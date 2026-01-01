package com.jackalcode.resident_management_system.care_interaction;

import com.jackalcode.resident_management_system.care_interaction.dto.CareInteractionResponse;
import com.jackalcode.resident_management_system.care_interaction.dto.CreateCareInteractionRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class CareInteractionController {

    private final CareInteractionService careInteractionService;

    public CareInteractionController(CareInteractionService careInteractionService) {
        this.careInteractionService = careInteractionService;
    }

    @GetMapping(path = "/api/v1/residents/{residentId}/care-interactions")
    public ResponseEntity<List<CareInteractionResponse>> getCareInteractions(@PathVariable UUID residentId) {

        List<CareInteractionResponse> careInteractionResponses = careInteractionService.getCareInteractions(residentId);

        return new ResponseEntity<>(careInteractionResponses, HttpStatus.OK);
    }

    @PostMapping(path = "/api/v1/residents/{residentId}/care-interactions")
    public ResponseEntity<CareInteractionResponse> createCareInteraction(@PathVariable UUID residentId,
                                                                         @RequestBody CreateCareInteractionRequest request) {

        CareInteractionResponse careInteractionResponse = careInteractionService.createCareInteraction(residentId, request);

        return new ResponseEntity<>(careInteractionResponse, HttpStatus.CREATED);
    }

    @GetMapping(path = "/api/v1/care-interactions/{interactionId}")
    public ResponseEntity<CareInteractionResponse> getCareInteraction(@PathVariable UUID interactionId) {

        CareInteractionResponse interactionResponse = careInteractionService.getCareInteraction(interactionId);

        return new ResponseEntity<>(interactionResponse, HttpStatus.OK);
    }
}
