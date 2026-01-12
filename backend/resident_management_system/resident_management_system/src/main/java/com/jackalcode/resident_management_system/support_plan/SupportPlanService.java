package com.jackalcode.resident_management_system.support_plan;

import com.jackalcode.resident_management_system.support_plan.dto.CreateSupportPlanRequest;
import com.jackalcode.resident_management_system.support_plan.dto.SupportPlanResponse;
import com.jackalcode.resident_management_system.support_plan.dto.SupportPlanSummaryResponse;
import com.jackalcode.resident_management_system.support_plan.dto.UpdateSupportPlanRequest;

import java.util.List;
import java.util.UUID;

public interface SupportPlanService {

    List<SupportPlanSummaryResponse> getActiveSupportPlans(UUID residentId);

    SupportPlanResponse createSupportPlan(UUID residentId, CreateSupportPlanRequest request);

    SupportPlanResponse getSupportPlan(UUID planId);

    SupportPlanResponse updateSupportPlan(UUID planId, UpdateSupportPlanRequest request);

    void deleteSupportPlan(UUID planId);
}
