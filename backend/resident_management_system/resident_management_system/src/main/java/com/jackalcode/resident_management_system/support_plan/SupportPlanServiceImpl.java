package com.jackalcode.resident_management_system.support_plan;

import com.jackalcode.resident_management_system.exception.ResidentNotFoundException;
import com.jackalcode.resident_management_system.resident.Resident;
import com.jackalcode.resident_management_system.resident.ResidentRepository;
import com.jackalcode.resident_management_system.support_plan.dto.SupportPlanSummaryResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SupportPlanServiceImpl implements SupportPlanService {

    private final SupportPlanRepository supportPlanRepository;
    private final ResidentRepository residentRepository;
    private final ModelMapper modelMapper;

    public SupportPlanServiceImpl(SupportPlanRepository supportPlanRepository, ResidentRepository residentRepository, ModelMapper modelMapper) {
        this.supportPlanRepository = supportPlanRepository;
        this.residentRepository = residentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<SupportPlanSummaryResponse> getActiveSupportPlans(UUID residentId) {

        //Get support plans with resident id
        List<SupportPlan> supportPlans = supportPlanRepository.findAllByResidentIdAndStatusAndArchivedFalseOrderByDomainAsc(
                residentId, SupportPlanStatus.ACTIVE
        );

        //if support plan list is empty, check if resident id exists
        if (supportPlans.isEmpty() && !residentRepository.existsById(residentId)) {
            throw new ResidentNotFoundException("Resident not found with id: " + residentId);
        }

        //Map support plans to support plan summary and return
        return supportPlans.stream()
                .map(this::mapToSummary)
                .toList();
    }

    private Resident getResidentById(UUID residentId) {
        return residentRepository.findById(residentId).orElseThrow(
                () -> new ResidentNotFoundException("Resident not found with id: " + residentId)
        );
    }

    private SupportPlanSummaryResponse mapToSummary(SupportPlan supportPlan) {

        return new SupportPlanSummaryResponse(
                supportPlan.getId(),
                supportPlan.getDomain(),
                supportPlan.getTitle(),
                supportPlan.getStatus(),
                supportPlan.getReviewDate()
        );
    }
}
