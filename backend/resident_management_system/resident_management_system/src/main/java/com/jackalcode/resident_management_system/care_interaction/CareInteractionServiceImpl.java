package com.jackalcode.resident_management_system.care_interaction;

import com.jackalcode.resident_management_system.care_interaction.dto.CareInteractionResponse;
import com.jackalcode.resident_management_system.exception.ResidentNotFoundException;
import com.jackalcode.resident_management_system.resident.ResidentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
