package com.jackalcode.resident_management_system.resident;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ResidentRepository extends JpaRepository<Resident, UUID> {
}
