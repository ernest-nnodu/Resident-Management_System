package com.jackalcode.resident_management_system.resident;

import com.jackalcode.resident_management_system.resident.dto.CreateResidentRequest;
import com.jackalcode.resident_management_system.resident.dto.ResidentResponse;
import com.jackalcode.resident_management_system.resident.dto.UpdateResidentRequest;

import java.util.List;
import java.util.UUID;

public interface ResidentService {

    List<ResidentResponse> getResidents();
    ResidentResponse createResident(CreateResidentRequest request);
    ResidentResponse getResidentById(UUID residentId);
    ResidentResponse updateResident(UUID residentId, UpdateResidentRequest request);
}
