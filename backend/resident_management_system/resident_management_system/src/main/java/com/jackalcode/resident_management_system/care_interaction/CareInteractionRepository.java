package com.jackalcode.resident_management_system.care_interaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CareInteractionRepository extends JpaRepository<CareInteraction, UUID> {

    List<CareInteraction> findAllByResidentIdOrderByRecordedAtDesc(UUID residentId);
}
