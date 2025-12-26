package com.jackalcode.resident_management_system.care_interaction;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CareInteractionRepository extends JpaRepository<CareInteraction, UUID> {
}
