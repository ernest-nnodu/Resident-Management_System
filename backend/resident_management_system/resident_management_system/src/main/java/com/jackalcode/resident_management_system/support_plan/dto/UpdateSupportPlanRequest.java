package com.jackalcode.resident_management_system.support_plan.dto;

import com.jackalcode.resident_management_system.support_plan.SupportPlanStatus;

import java.time.LocalDate;

public record UpdateSupportPlanRequest(

        String title,

        String content,

        SupportPlanStatus status,

        LocalDate reviewDate
) {
}
