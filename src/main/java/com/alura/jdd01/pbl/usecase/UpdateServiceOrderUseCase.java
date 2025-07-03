package com.alura.jdd01.pbl.usecase;

import com.alura.jdd01.pbl.domain.entity.ServiceOrder;
import com.alura.jdd01.pbl.domain.repository.ServiceOrderRepository;
import com.alura.jdd01.pbl.domain.repository.TechnicianRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateServiceOrderUseCase {
    private final ServiceOrderRepository serviceOrderRepository;
    private final TechnicianRepository technicianRepository;
    
    public ServiceOrder execute(Long id, String equipment, Long technicianId, String problemDescription) {
        ServiceOrder existingOrder = serviceOrderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ordem de serviço não encontrada"));
        
        technicianRepository.findById(technicianId)
                .orElseThrow(() -> new IllegalArgumentException("Técnico não encontrado"));
        
        ServiceOrder updatedOrder = existingOrder.update(equipment, technicianId, problemDescription);
        return serviceOrderRepository.save(updatedOrder);
    }
}