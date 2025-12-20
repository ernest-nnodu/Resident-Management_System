package com.jackalcode.resident_management_system.resident;

import com.jackalcode.resident_management_system.resident.dto.CreateResidentRequest;
import com.jackalcode.resident_management_system.resident.dto.ResidentResponse;

import java.util.List;

public interface ResidentService {

    List<ResidentResponse> getResidents();
    ResidentResponse createResident(CreateResidentRequest createResidentRequest);
}
