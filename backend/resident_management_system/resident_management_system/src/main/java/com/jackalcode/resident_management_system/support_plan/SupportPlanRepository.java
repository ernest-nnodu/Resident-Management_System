package com.jackalcode.resident_management_system.support_plan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SupportPlanRepository extends JpaRepository<SupportPlan, UUID> {

    boolean existsByResidentIdAndDomainAndStatusAndArchivedFalse(
            UUID residentId,
            SupportPlanDomain domain,
            SupportPlanStatus status
    );

    List<SupportPlan> findAllByResidentIdAndStatusAndArchivedFalseOrderByDomainAsc(
            UUID residentId,
            SupportPlanStatus status
    );

    Optional<SupportPlan> findByResidentIdAndArchivedFalse(UUID residentId);

}
