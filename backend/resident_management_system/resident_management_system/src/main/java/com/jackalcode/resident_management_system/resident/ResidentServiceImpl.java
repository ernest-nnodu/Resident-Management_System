package com.jackalcode.resident_management_system.resident;

import com.jackalcode.resident_management_system.exception.ResidentAlreadyExistsException;
import com.jackalcode.resident_management_system.resident.dto.CreateResidentRequest;
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

    @Override
    public ResidentResponse createResident(CreateResidentRequest createResidentRequest) {

        /*if (residentRepository.existsByNhsNumber(createResidentRequest.nhsNumber())) {
            throw new ResidentAlreadyExistsException("Resident already exists with nhs number: "
                    + createResidentRequest.nhsNumber());
        }

        if (residentRepository.existsByFirstNameAndLastNameAndDateOfBirth(createResidentRequest.firstName(),
                createResidentRequest.lastName(), createResidentRequest.dateOfBirth())) {
            throw new ResidentAlreadyExistsException("Resident already exists with first name: " )
        }*/

        Resident residentToSave = mapper.map(createResidentRequest, Resident.class);
        Resident savedResident = residentRepository.save(residentToSave);

        return mapToResponse(savedResident);
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
