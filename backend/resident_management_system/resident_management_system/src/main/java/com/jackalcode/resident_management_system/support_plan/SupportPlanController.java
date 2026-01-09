package com.jackalcode.resident_management_system.support_plan;

import com.jackalcode.resident_management_system.support_plan.dto.SupportPlanSummaryResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
