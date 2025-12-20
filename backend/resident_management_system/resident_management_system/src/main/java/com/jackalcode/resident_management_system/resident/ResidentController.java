package com.jackalcode.resident_management_system.resident;

import com.jackalcode.resident_management_system.resident.dto.CreateResidentRequest;
import com.jackalcode.resident_management_system.resident.dto.ResidentResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/residents")
public class ResidentController {

    private final ResidentService residentService;

    public ResidentController(ResidentService residentService) {
        this.residentService = residentService;
    }

    @GetMapping
    public ResponseEntity<List<ResidentResponse>> getResidents() {
        List<ResidentResponse> residentResponses = residentService.getResidents();

        return new ResponseEntity<>(residentResponses, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResidentResponse> createResident(@RequestBody CreateResidentRequest residentRequest) {

        ResidentResponse residentResponse = residentService.createResident(residentRequest);

        return new ResponseEntity<>(residentResponse, HttpStatus.OK);
    }
}
