package com.jackalcode.resident_management_system.support_plan;

import com.jackalcode.resident_management_system.support_plan.dto.CreateSupportPlanRequest;
import com.jackalcode.resident_management_system.support_plan.dto.SupportPlanResponse;
import com.jackalcode.resident_management_system.support_plan.dto.SupportPlanSummaryResponse;
import com.jackalcode.resident_management_system.support_plan.dto.UpdateSupportPlanRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class SupportPlanController {

    private final SupportPlanService supportPlanService;

    public SupportPlanController(SupportPlanService supportPlanService) {
        this.supportPlanService = supportPlanService;
    }

    @GetMapping(path = "/api/v1/residents/{residentId}/support-plans")
    public ResponseEntity<List<SupportPlanSummaryResponse>> getActiveSupportPlans(@PathVariable UUID residentId) {

        List<SupportPlanSummaryResponse> supportPlanSummaries = supportPlanService.getActiveSupportPlans(residentId);

        return new ResponseEntity<>(supportPlanSummaries, HttpStatus.OK);
    }

    @PostMapping(path = "/api/v1/residents/{residentId}/support-plans")
    public ResponseEntity<SupportPlanResponse> createSupportPlan(@PathVariable UUID residentId,
                                                                 @RequestBody CreateSupportPlanRequest request) {

        SupportPlanResponse response = supportPlanService.createSupportPlan(residentId, request);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping(path = "/api/v1/support-plans/{planId}")
    public ResponseEntity<SupportPlanResponse> getSupportPlan(@PathVariable UUID planId) {

        SupportPlanResponse response = supportPlanService.getSupportPlan(planId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PatchMapping(path = "/api/v1/support-plans/{planId}")
    public ResponseEntity<SupportPlanResponse> updateSupportPlan(@PathVariable UUID planId,
                                                                 @RequestBody UpdateSupportPlanRequest request) {

        SupportPlanResponse response = supportPlanService.updateSupportPlan(planId, request);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(path = "/api/v1/support-plans/{planId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSupportPlan(@PathVariable UUID planId) {

        supportPlanService.deleteSupportPlan(planId);
    }
}
