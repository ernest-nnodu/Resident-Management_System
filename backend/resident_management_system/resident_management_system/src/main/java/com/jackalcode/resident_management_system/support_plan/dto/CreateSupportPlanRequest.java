package com.jackalcode.resident_management_system.support_plan.dto;

import com.jackalcode.resident_management_system.support_plan.SupportPlanDomain;
import com.jackalcode.resident_management_system.support_plan.SupportPlanStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Schema(description = "Create support plan DTO")
public record CreateSupportPlanRequest(

        @Schema(description = "Support plan domain")
        @NotNull(message = "Support plan domain is required")
        SupportPlanDomain domain,

        @Schema(description = "Support plan title")
        @NotBlank(message = "Support plan title is required")
        String title,

        @Schema(description = "Support plan content")
        @NotBlank(message = "Support plan content is required")
        String content,

        @Schema(description = "Support plan status")
        @NotNull(message = "Support plan status is required")
        SupportPlanStatus status,

        @Schema(description = "Support plan start date")
        @NotNull(message = "Support plan start date is required")
        LocalDate startDate,

        @Schema(description = "Support plan review date")
        @NotNull(message = "Support plan review date is required")
        LocalDate reviewDate
) {
}
