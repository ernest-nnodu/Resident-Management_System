package com.jackalcode.resident_management_system.care_interaction;

import com.jackalcode.resident_management_system.care_interaction.dto.CareInteractionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
