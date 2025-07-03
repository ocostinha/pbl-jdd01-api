package com.alura.jdd01.pbl.usecase;

import com.alura.jdd01.pbl.domain.entity.Technician;
import com.alura.jdd01.pbl.domain.repository.TechnicianRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindTechnicianByIdUseCase {
    private final TechnicianRepository technicianRepository;
    
    public Technician execute(Long id) {
        return technicianRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Técnico não encontrado"));
    }
}