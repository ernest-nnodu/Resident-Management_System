package com.jackalcode.resident_management_system.support_plan.dto;

import com.jackalcode.resident_management_system.support_plan.SupportPlanDomain;
import com.jackalcode.resident_management_system.support_plan.SupportPlanStatus;

import java.time.LocalDate;
import java.util.UUID;

public record SupportPlanSummaryResponse(

        UUID id,

        SupportPlanDomain domain,

        String title,

        SupportPlanStatus status,

        LocalDate reviewDate
) {
}
