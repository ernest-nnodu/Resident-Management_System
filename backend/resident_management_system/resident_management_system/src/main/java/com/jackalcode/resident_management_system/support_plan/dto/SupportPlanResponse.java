package com.jackalcode.resident_management_system.support_plan.dto;

import com.jackalcode.resident_management_system.support_plan.SupportPlanDomain;
import com.jackalcode.resident_management_system.support_plan.SupportPlanStatus;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

public record SupportPlanResponse(

        UUID id,

        UUID residentId,

        SupportPlanDomain domain,

        String title,

        String content,

        SupportPlanStatus status,

        LocalDate startDate,

        LocalDate reviewDate,

        Instant createdAt,

        Instant updatedAt
) {
}
