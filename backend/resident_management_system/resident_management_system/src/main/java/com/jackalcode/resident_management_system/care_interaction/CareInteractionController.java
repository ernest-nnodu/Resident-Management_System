package com.jackalcode.resident_management_system.care_interaction;

import com.jackalcode.resident_management_system.care_interaction.dto.CareInteractionResponse;
import com.jackalcode.resident_management_system.care_interaction.dto.CreateCareInteractionRequest;
import com.jackalcode.resident_management_system.care_interaction.dto.UpdateCareInteractionRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Care Interaction REST API", description = "Provides CRUD operations for managing care interactions")
@RestController
public class CareInteractionController {

    private final CareInteractionService careInteractionService;

    public CareInteractionController(CareInteractionService careInteractionService) {
        this.careInteractionService = careInteractionService;
    }

    @Operation(summary = "Retrieve care interactions for resident", description = "Retrieves all care interactions of a resident")
    @ApiResponse(responseCode = "200", description = "Care interactions retrieved successfully")
    @GetMapping(path = "/api/v1/residents/{residentId}/care-interactions")
    public ResponseEntity<List<CareInteractionResponse>> getCareInteractions(@PathVariable UUID residentId) {

        List<CareInteractionResponse> careInteractionResponses = careInteractionService.getCareInteractions(residentId);

        return new ResponseEntity<>(careInteractionResponses, HttpStatus.OK);
    }

    @Operation(summary = "Create new care interaction", description = "Create and persist new care interaction for a resident")
    @ApiResponse(responseCode = "201", description = "Care interaction created successfully")
    @PostMapping(path = "/api/v1/residents/{residentId}/care-interactions")
    public ResponseEntity<CareInteractionResponse> createCareInteraction(@PathVariable UUID residentId,
                                                                         @Valid @RequestBody CreateCareInteractionRequest request) {

        CareInteractionResponse careInteractionResponse = careInteractionService.createCareInteraction(residentId, request);

        return new ResponseEntity<>(careInteractionResponse, HttpStatus.CREATED);
    }

    @Operation(summary = "Retrieve care interaction", description = "Retrieve a care interaction by Id")
    @ApiResponse(responseCode = "200", description = "Care interaction retrieved successfully")
    @GetMapping(path = "/api/v1/care-interactions/{interactionId}")
    public ResponseEntity<CareInteractionResponse> getCareInteraction(@PathVariable UUID interactionId) {

        CareInteractionResponse interactionResponse = careInteractionService.getCareInteraction(interactionId);

        return new ResponseEntity<>(interactionResponse, HttpStatus.OK);
    }

    @Operation(summary = "Modify care interaction", description = "Modifies an existing care interaction")
    @ApiResponse(responseCode = "200", description = "Care interaction updated successfully")
    @PatchMapping(path = "/api/v1/care-interactions/{interactionId}")
    public ResponseEntity<CareInteractionResponse> updateCareInteraction(@PathVariable UUID interactionId,
                                                                         @RequestBody UpdateCareInteractionRequest request) {

        CareInteractionResponse interactionResponse = careInteractionService.updateCareInteraction(interactionId, request);

        return new ResponseEntity<>(interactionResponse, HttpStatus.OK);
    }

    @Operation(summary = "Delete care interaction", description = "Delete an existing care interaction")
    @ApiResponse(responseCode = "209", description = "Care interaction deleted successfully")
    @DeleteMapping(path = "/api/v1/care-interactions/{interactionId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCareInteraction(@PathVariable UUID interactionId) {

        careInteractionService.deleteCareInteraction(interactionId);
    }
}
