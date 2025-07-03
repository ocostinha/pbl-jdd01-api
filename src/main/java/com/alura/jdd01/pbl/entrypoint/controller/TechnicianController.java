package com.alura.jdd01.pbl.entrypoint.controller;

import com.alura.jdd01.pbl.domain.entity.Technician;
import com.alura.jdd01.pbl.entrypoint.dto.CreateTechnicianRequest;
import com.alura.jdd01.pbl.entrypoint.dto.TechnicianResponse;
import com.alura.jdd01.pbl.usecase.CreateTechnicianUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/technicians")
@RequiredArgsConstructor
public class TechnicianController {
    private final CreateTechnicianUseCase createTechnicianUseCase;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TechnicianResponse create(@Valid @RequestBody CreateTechnicianRequest request) {
        Technician technician = createTechnicianUseCase.execute(
                request.getName(), 
                request.getEmail(), 
                request.getPhone()
        );
        return TechnicianResponse.from(technician);
    }
}