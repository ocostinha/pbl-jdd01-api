package com.alura.jdd01.pbl.usecase;

import com.alura.jdd01.pbl.domain.entity.ServiceOrder;
import com.alura.jdd01.pbl.domain.repository.ServiceOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CloseServiceOrderUseCase {
    private final ServiceOrderRepository serviceOrderRepository;
    
    public ServiceOrder execute(Long id) {
        ServiceOrder serviceOrder = serviceOrderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ordem de serviço não encontrada"));
        
        ServiceOrder closedOrder = serviceOrder.close();
        return serviceOrderRepository.save(closedOrder);
    }
}