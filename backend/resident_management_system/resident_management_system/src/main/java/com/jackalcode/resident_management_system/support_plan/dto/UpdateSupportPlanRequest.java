package com.jackalcode.resident_management_system.support_plan.dto;

import com.jackalcode.resident_management_system.support_plan.SupportPlanStatus;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

@Schema(description = "Update support plan DTO")
public record UpdateSupportPlanRequest(

        @Schema(description = "Support plan title")
        String title,

        @Schema(description = "Support plan content")
        String content,

        @Schema(description = "Support plan status")
        SupportPlanStatus status,

        @Schema(description = "Support plan review date")
        LocalDate reviewDate
) {
}
