package com.alura.jdd01.pbl.usecase;

import com.alura.jdd01.pbl.domain.repository.TechnicianRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteTechnicianUseCase {
    private final TechnicianRepository technicianRepository;
    
    public void execute(Long id) {
        if (!technicianRepository.findById(id).isPresent()) {
            throw new IllegalArgumentException("Técnico não encontrado");
        }
        technicianRepository.deleteById(id);
    }
}