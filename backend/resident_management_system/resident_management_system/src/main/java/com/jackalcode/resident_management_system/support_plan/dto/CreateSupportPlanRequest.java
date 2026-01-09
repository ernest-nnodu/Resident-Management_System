package com.jackalcode.resident_management_system.support_plan.dto;

import com.jackalcode.resident_management_system.support_plan.SupportPlanDomain;
import com.jackalcode.resident_management_system.support_plan.SupportPlanStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CreateSupportPlanRequest(

        @NotNull
        SupportPlanDomain domain,

        @NotBlank
        String title,

        @NotBlank
        String content,

        @NotNull
        SupportPlanStatus status,

        @NotNull
        LocalDate startDate,

        @NotNull
        LocalDate reviewDate
) {
}
