package com.jackalcode.resident_management_system.support_plan.dto;

import com.jackalcode.resident_management_system.support_plan.SupportPlanDomain;
import com.jackalcode.resident_management_system.support_plan.SupportPlanStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CreateSupportPlanRequest(

        @NotNull(message = "Support plan domain is required")
        SupportPlanDomain domain,

        @NotBlank(message = "Support plan title is required")
        String title,

        @NotBlank(message = "Support plan content is required")
        String content,

        @NotNull(message = "Support plan status is required")
        SupportPlanStatus status,

        @NotNull(message = "Support plan start date is required")
        LocalDate startDate,

        @NotNull(message = "Support plan review date is required")
        LocalDate reviewDate
) {
}
