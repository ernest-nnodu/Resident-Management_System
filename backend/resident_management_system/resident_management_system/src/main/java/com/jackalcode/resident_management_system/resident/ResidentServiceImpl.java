package com.jackalcode.resident_management_system.resident;

import com.jackalcode.resident_management_system.exception.ResidentAlreadyExistsException;
import com.jackalcode.resident_management_system.exception.ResidentNotFoundException;
import com.jackalcode.resident_management_system.resident.dto.CreateResidentRequest;
import com.jackalcode.resident_management_system.resident.dto.ResidentResponse;
import com.jackalcode.resident_management_system.resident.dto.UpdateResidentRequest;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

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
    public ResidentResponse createResident(CreateResidentRequest request) {

        if ( request.nhsNumber() != null && residentRepository.existsByNhsNumber(request.nhsNumber())) {
            throw new ResidentAlreadyExistsException("Resident already exists with nhs number: "
                    + request.nhsNumber());
        }

        if (residentRepository.existsByFirstNameAndLastNameAndDateOfBirth(request.firstName(),
                request.lastName(), request.dateOfBirth())) {
            throw new ResidentAlreadyExistsException("Resident already exists with fullname: " + request.firstName() + " "
            + request.lastName() + ", date of birth: " + request.dateOfBirth());
        }

        Resident residentToSave = mapper.map(request, Resident.class);
        residentToSave.setAdmissionDate(LocalDate.now());
        System.out.println(residentToSave.getAdmissionDate());
        Resident savedResident = residentRepository.save(residentToSave);

        return mapToResponse(savedResident);
    }

    @Override
    public ResidentResponse getResident(UUID residentId) {

        Resident resident = getResidentById(residentId);

        return mapToResponse(resident);
    }

    @Override
    @Transactional
    public ResidentResponse updateResident(UUID residentId, UpdateResidentRequest request) {

        Resident existingResident = getResidentById(residentId);

        if (request.nhsNumber() != null && !(request.nhsNumber().equals(existingResident.getNhsNumber()))
                && residentRepository.existsByNhsNumber(request.nhsNumber())) {
            throw new ResidentAlreadyExistsException("Resident already exists with nhs number: " + request.nhsNumber());
        }

        mapper.map(request, existingResident);
        Resident updatedResident = residentRepository.save(existingResident);

        return mapToResponse(updatedResident);
    }

    @Override
    public void deleteResident(UUID residentId) {

        Resident existingResident = getResidentById(residentId);

        residentRepository.delete(existingResident);
    }

    private Resident getResidentById(UUID residentId) {
        return residentRepository.findById(residentId).orElseThrow(
                () -> new ResidentNotFoundException("Resident not found with id: " + residentId)
        );
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
