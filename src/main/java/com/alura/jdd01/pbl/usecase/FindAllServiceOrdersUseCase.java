package com.alura.jdd01.pbl.usecase;

import com.alura.jdd01.pbl.domain.entity.ServiceOrder;
import com.alura.jdd01.pbl.domain.repository.ServiceOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllServiceOrdersUseCase {
    private final ServiceOrderRepository serviceOrderRepository;
    
    public List<ServiceOrder> execute() {
        return serviceOrderRepository.findAll();
    }
}