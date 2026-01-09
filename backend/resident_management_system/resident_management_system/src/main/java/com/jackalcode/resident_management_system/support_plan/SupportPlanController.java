package com.jackalcode.resident_management_system.support_plan;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupportPlanController {

    private final SupportPlanService supportPlanService;

    public SupportPlanController(SupportPlanService supportPlanService) {
        this.supportPlanService = supportPlanService;
    }
}
