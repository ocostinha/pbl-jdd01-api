package com.alura.jdd01.pbl.usecase;

import com.alura.jdd01.pbl.domain.entity.Technician;
import com.alura.jdd01.pbl.domain.repository.TechnicianRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllTechniciansUseCase {
    private final TechnicianRepository technicianRepository;
    
    public List<Technician> execute() {
        return technicianRepository.findAll();
    }
}