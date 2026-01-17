package com.jackalcode.resident_management_system.support_plan.dto;

import com.jackalcode.resident_management_system.support_plan.SupportPlanDomain;
import com.jackalcode.resident_management_system.support_plan.SupportPlanStatus;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Schema(description = "Support plan response DTO")
public record SupportPlanResponse(

        @Schema(description = "Support plan ID")
        UUID id,

        @Schema(description = "Resident ID")
        UUID residentId,

        @Schema(description = "Support plan domain")
        SupportPlanDomain domain,

        @Schema(description = "Support plan title")
        String title,

        @Schema(description = "Support plan content")
        String content,

        @Schema(description = "Support plan status")
        SupportPlanStatus status,

        @Schema(description = "Support plan start date")
        LocalDate startDate,

        @Schema(description = "Support plan review date")
        LocalDate reviewDate,

        @Schema(description = "Support plan creation time")
        Instant createdAt,

        @Schema(description = "Support plan modification time")
        Instant updatedAt
) {
}
