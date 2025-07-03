package com.alura.jdd01.pbl.usecase;

import com.alura.jdd01.pbl.domain.entity.Technician;
import com.alura.jdd01.pbl.domain.repository.TechnicianRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateTechnicianUseCase {
    private final TechnicianRepository technicianRepository;
    
    public Technician execute(Long id, String name, String email, String phone) {
        Technician existingTechnician = technicianRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Técnico não encontrado"));
        
        Technician updatedTechnician = existingTechnician.update(name, email, phone);
        return technicianRepository.save(updatedTechnician);
    }
}