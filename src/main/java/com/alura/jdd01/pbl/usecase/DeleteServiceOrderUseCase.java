package com.alura.jdd01.pbl.usecase;

import com.alura.jdd01.pbl.domain.repository.ServiceOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteServiceOrderUseCase {
    private final ServiceOrderRepository serviceOrderRepository;
    
    public void execute(Long id) {
        if (!serviceOrderRepository.findById(id).isPresent()) {
            throw new IllegalArgumentException("Ordem de serviço não encontrada");
        }
        serviceOrderRepository.deleteById(id);
    }
}