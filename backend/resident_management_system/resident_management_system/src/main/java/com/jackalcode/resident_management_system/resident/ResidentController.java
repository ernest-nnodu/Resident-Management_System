package com.jackalcode.resident_management_system.resident;

import com.jackalcode.resident_management_system.resident.dto.CreateResidentRequest;
import com.jackalcode.resident_management_system.resident.dto.ResidentResponse;
import com.jackalcode.resident_management_system.resident.dto.UpdateResidentRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Resident REST API", description = "Provides CRUD operations for managing residents")
@RestController
@RequestMapping("/api/v1/residents")
public class ResidentController {

    private final ResidentService residentService;

    public ResidentController(ResidentService residentService) {
        this.residentService = residentService;
    }

    @Operation(summary = "Retrieve residents", description = "Retrieves All residents")
    @ApiResponse(responseCode = "200", description = "Residents retrieved successfully")
    @GetMapping
    public ResponseEntity<List<ResidentResponse>> getResidents() {
        List<ResidentResponse> residentResponses = residentService.getResidents();

        return new ResponseEntity<>(residentResponses, HttpStatus.OK);
    }

    @Operation(summary = "Create new resident", description = "Create and persist new resident")
    @ApiResponse(responseCode = "201", description = "Resident created successfully")
    @PostMapping
    public ResponseEntity<ResidentResponse> createResident(@Valid @RequestBody CreateResidentRequest residentRequest) {

        ResidentResponse residentResponse = residentService.createResident(residentRequest);

        return new ResponseEntity<>(residentResponse, HttpStatus.CREATED);
    }

    @Operation(summary = "Retrieve a resident", description = "Retrieve a resident by Id")
    @ApiResponse(responseCode = "200", description = "Resident retrieved successfully")
    @GetMapping("/{residentId}")
    public ResponseEntity<ResidentResponse> getResident(@PathVariable UUID residentId) {

        ResidentResponse residentResponse = residentService.getResident(residentId);

        return new ResponseEntity<>(residentResponse, HttpStatus.OK);
    }

    @Operation(summary = "Modify a resident", description = "Modify existing resident info")
    @ApiResponse(responseCode = "200", description = "Resident updated successfully")
    @PutMapping("/{residentId}")
    public ResponseEntity<ResidentResponse> updateResident(@PathVariable UUID residentId,
                                                           @Valid @RequestBody UpdateResidentRequest request) {

        ResidentResponse residentResponse = residentService.updateResident(residentId, request);

        return new ResponseEntity<>(residentResponse, HttpStatus.OK);
    }

    @Operation(summary = "Delete a resident", description = "Deletes an existing resident")
    @ApiResponse(responseCode = "209", description = "Resident deleted successfully")
    @DeleteMapping("/{residentId}")
    public ResponseEntity<HttpStatus> deleteResident(@PathVariable UUID residentId) {

        residentService.deleteResident(residentId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
