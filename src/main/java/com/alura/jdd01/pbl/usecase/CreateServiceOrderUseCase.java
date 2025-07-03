package com.alura.jdd01.pbl.usecase;

import com.alura.jdd01.pbl.domain.entity.ServiceOrder;
import com.alura.jdd01.pbl.domain.repository.ServiceOrderRepository;
import com.alura.jdd01.pbl.domain.repository.TechnicianRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateServiceOrderUseCase {
    private final ServiceOrderRepository serviceOrderRepository;
    private final TechnicianRepository technicianRepository;
    
    public ServiceOrder execute(String equipment, Long technicianId, String problemDescription) {
        technicianRepository.findById(technicianId)
                .orElseThrow(() -> new IllegalArgumentException("Técnico não encontrado"));
        
        ServiceOrder serviceOrder = ServiceOrder.create(equipment, technicianId, problemDescription);
        return serviceOrderRepository.save(serviceOrder);
    }
}