package com.jackalcode.resident_management_system.resident;

import com.jackalcode.resident_management_system.resident.dto.ResidentResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResidentServiceImpl implements ResidentService {

    private final ResidentRepository residentRepository;
    private final ModelMapper mapper;

    public ResidentServiceImpl(ResidentRepository residentRepository, ModelMapper mapper) {
        this.residentRepository = residentRepository;
        this.mapper = mapper;
    }

    @Override
    public List<ResidentResponse> getResidents() {
        List<Resident> residents = residentRepository.findAll();

        return residents.stream()
                .map(this::mapToResponse)
                .toList();
    }

    private ResidentResponse mapToResponse(Resident resident) {
        return new ResidentResponse(
                resident.getId(),
                resident.getFirstName(),
                resident.getLastName(),
                resident.getDateOfBirth(),
                resident.getGender(),
                resident.getAddress(),
                resident.getAdmissionDate(),
                resident.getPrimaryPhoneNumber(),
                resident.getNhsNumber(),
                resident.getAllergies()
        );
    }
}
