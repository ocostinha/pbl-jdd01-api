package com.alura.jdd01.pbl.entrypoint.controller;

import com.alura.jdd01.pbl.domain.entity.Technician;
import com.alura.jdd01.pbl.entrypoint.dto.CreateTechnicianRequest;
import com.alura.jdd01.pbl.entrypoint.dto.UpdateTechnicianRequest;
import com.alura.jdd01.pbl.entrypoint.dto.TechnicianResponse;
import com.alura.jdd01.pbl.usecase.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/technicians")
@RequiredArgsConstructor
public class TechnicianController {
    private final CreateTechnicianUseCase createTechnicianUseCase;
    private final FindTechnicianByIdUseCase findTechnicianByIdUseCase;
    private final FindAllTechniciansUseCase findAllTechniciansUseCase;
    private final UpdateTechnicianUseCase updateTechnicianUseCase;
    private final DeleteTechnicianUseCase deleteTechnicianUseCase;
    
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
    
    @GetMapping
    public List<TechnicianResponse> findAll() {
        return findAllTechniciansUseCase.execute().stream()
                .map(TechnicianResponse::from)
                .toList();
    }
    
    @GetMapping("/{id}")
    public TechnicianResponse findById(@PathVariable Long id) {
        Technician technician = findTechnicianByIdUseCase.execute(id);
        return TechnicianResponse.from(technician);
    }
    
    @PutMapping("/{id}")
    public TechnicianResponse update(@PathVariable Long id, @Valid @RequestBody UpdateTechnicianRequest request) {
        Technician technician = updateTechnicianUseCase.execute(
                id,
                request.getName(),
                request.getEmail(),
                request.getPhone()
        );
        return TechnicianResponse.from(technician);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        deleteTechnicianUseCase.execute(id);
    }
}