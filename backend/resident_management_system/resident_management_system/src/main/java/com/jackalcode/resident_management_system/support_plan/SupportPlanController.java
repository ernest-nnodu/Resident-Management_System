package com.jackalcode.resident_management_system.support_plan;

import com.jackalcode.resident_management_system.support_plan.dto.CreateSupportPlanRequest;
import com.jackalcode.resident_management_system.support_plan.dto.SupportPlanResponse;
import com.jackalcode.resident_management_system.support_plan.dto.SupportPlanSummaryResponse;
import com.jackalcode.resident_management_system.support_plan.dto.UpdateSupportPlanRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Support Plan REST API", description = "Provides CRUD operations for managing support plans")
@RestController
public class SupportPlanController {

    private final SupportPlanService supportPlanService;

    public SupportPlanController(SupportPlanService supportPlanService) {
        this.supportPlanService = supportPlanService;
    }

    @Operation(summary = "Retrieve support plans", description = "Retrieves all support plans for a resident")
    @ApiResponse(responseCode = "200", description = "Support plans retrieved successfully")
    @GetMapping(path = "/api/v1/residents/{residentId}/support-plans")
    public ResponseEntity<List<SupportPlanSummaryResponse>> getActiveSupportPlans(@PathVariable UUID residentId) {

        List<SupportPlanSummaryResponse> supportPlanSummaries = supportPlanService.getActiveSupportPlans(residentId);

        return new ResponseEntity<>(supportPlanSummaries, HttpStatus.OK);
    }

    @Operation(summary = "Create support plan", description = "Create and persist a support plan for a resident")
    @ApiResponse(responseCode = "201", description = "Support plan created successfully")
    @PostMapping(path = "/api/v1/residents/{residentId}/support-plans")
    public ResponseEntity<SupportPlanResponse> createSupportPlan(@PathVariable UUID residentId,
                                                                 @Valid @RequestBody CreateSupportPlanRequest request) {

        SupportPlanResponse response = supportPlanService.createSupportPlan(residentId, request);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Operation(summary = "Retrieve a support plan", description = "Retrieve a support plan by Id")
    @ApiResponse(responseCode = "200", description = "Support Plan retrieved successfully")
    @GetMapping(path = "/api/v1/support-plans/{planId}")
    public ResponseEntity<SupportPlanResponse> getSupportPlan(@PathVariable UUID planId) {

        SupportPlanResponse response = supportPlanService.getSupportPlan(planId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(summary = "Modify support plan", description = "Modify an existing support plan")
    @ApiResponse(responseCode = "200", description = "Support plan updated successfully")
    @PatchMapping(path = "/api/v1/support-plans/{planId}")
    public ResponseEntity<SupportPlanResponse> updateSupportPlan(@PathVariable UUID planId,
                                                                 @RequestBody UpdateSupportPlanRequest request) {

        SupportPlanResponse response = supportPlanService.updateSupportPlan(planId, request);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(summary = "Delete support plan", description = "Delete an existing support plan")
    @ApiResponse(responseCode = "209", description = "Support plan deleted successfully")
    @DeleteMapping(path = "/api/v1/support-plans/{planId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSupportPlan(@PathVariable UUID planId) {

        supportPlanService.deleteSupportPlan(planId);
    }
}
