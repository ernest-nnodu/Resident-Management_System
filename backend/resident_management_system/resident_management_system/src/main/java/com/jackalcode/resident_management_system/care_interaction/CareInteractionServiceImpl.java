package com.jackalcode.resident_management_system.care_interaction;

import com.jackalcode.resident_management_system.care_interaction.dto.CareInteractionResponse;
import com.jackalcode.resident_management_system.care_interaction.dto.CreateCareInteractionRequest;
import com.jackalcode.resident_management_system.care_interaction.dto.UpdateCareInteractionRequest;
import com.jackalcode.resident_management_system.exception.CareInteractionNotFoundException;
import com.jackalcode.resident_management_system.exception.ResidentNotFoundException;
import com.jackalcode.resident_management_system.resident.Resident;
import com.jackalcode.resident_management_system.resident.ResidentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class CareInteractionServiceImpl implements CareInteractionService {

    private final CareInteractionRepository careInteractionRepository;
    private final ResidentRepository residentRepository;
    private final ModelMapper modelMapper;

    public CareInteractionServiceImpl(CareInteractionRepository careInteractionRepository, ResidentRepository residentRepository, ModelMapper modelMapper) {
        this.careInteractionRepository = careInteractionRepository;
        this.residentRepository = residentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CareInteractionResponse> getCareInteractions(UUID residentId) {

        //get care interactions with resident id
        List<CareInteraction> careInteractions = careInteractionRepository
                .findAllByResidentIdOrderByRecordedAtDesc(residentId);

        //if list is empty, check if resident id exists
        if (careInteractions.isEmpty() && !residentRepository.existsById(residentId)) {
            throw new ResidentNotFoundException("Resident not found with id: " + residentId);
        }

        //convert care interactions to care interaction response
        return careInteractions.stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    @Transactional
    public CareInteractionResponse createCareInteraction(UUID residentId, CreateCareInteractionRequest request) {

        //Get resident with resident id, throw exception if resident id invalid
        Resident resident = residentRepository.findById(residentId).orElseThrow(
                () -> new ResidentNotFoundException("Resident not found with id: " + residentId));

        //Map request to care interaction entity
        CareInteraction careInteractionToSave = modelMapper.map(request, CareInteraction.class);

        //Set resident in care interaction entity
        careInteractionToSave.setResident(resident);

        //Save care interaction entity to database
        CareInteraction savedCareInteraction = careInteractionRepository.save(careInteractionToSave);

        //Map saved care interaction entity to care interaction response and return
        return mapToResponse(savedCareInteraction);
    }

    @Override
    public CareInteractionResponse getCareInteraction(UUID careInteractionId) {

        //Obtain care interaction entity with the given id
        CareInteraction interaction = getInteraction(careInteractionId);

        //map interaction entity to response and return
        return mapToResponse(interaction);
    }

    @Override
    @Transactional
    public CareInteractionResponse updateCareInteraction(UUID careInteractionId, UpdateCareInteractionRequest request) {

        //Obtain care interaction entity with the given id
        CareInteraction existingInteraction = getInteraction(careInteractionId);

        //Update the obtained care interaction entity with request data which are not null
        modelMapper.map(request, existingInteraction);

        //Save updated care interaction entity to database
        CareInteraction updatedInteraction = careInteractionRepository.save(existingInteraction);

        //map care interaction entity to response and return
        return mapToResponse(updatedInteraction);
    }

    @Override
    @Transactional
    public void deleteCareInteraction(UUID careInteractionId) {

        //Obtain care interaction to be deleted with the given interaction id
        CareInteraction existingInteraction = getInteraction(careInteractionId);

        //Delete interaction from the database
        careInteractionRepository.delete(existingInteraction);
    }

    private CareInteraction getInteraction(UUID careInteractionId) {
        return careInteractionRepository.findById(careInteractionId).orElseThrow(
                () -> new CareInteractionNotFoundException("Care interaction not found with id: " + careInteractionId)
        );
    }

    private CareInteractionResponse mapToResponse(CareInteraction careInteraction) {
        return new CareInteractionResponse(
                careInteraction.getId(),
                careInteraction.getResident().getId(),
                careInteraction.getType(),
                careInteraction.getDescription(),
                careInteraction.getRecordedOn(),
                careInteraction.getRecordedAt()
        );
    }
}
