package com.alura.jdd01.pbl.usecase;

import com.alura.jdd01.pbl.domain.entity.Technician;
import com.alura.jdd01.pbl.domain.repository.TechnicianRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateTechnicianUseCase {
    private final TechnicianRepository technicianRepository;
    
    public Technician execute(String name, String email, String phone) {
        Technician technician = Technician.create(name, email, phone);
        return technicianRepository.save(technician);
    }
}