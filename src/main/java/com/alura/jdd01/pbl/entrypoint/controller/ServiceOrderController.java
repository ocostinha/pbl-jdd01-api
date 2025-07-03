package com.alura.jdd01.pbl.entrypoint.controller;

import com.alura.jdd01.pbl.domain.entity.ServiceOrder;
import com.alura.jdd01.pbl.entrypoint.dto.CreateServiceOrderRequest;
import com.alura.jdd01.pbl.entrypoint.dto.ServiceOrderResponse;
import com.alura.jdd01.pbl.usecase.CreateServiceOrderUseCase;
import com.alura.jdd01.pbl.usecase.CloseServiceOrderUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service-orders")
@RequiredArgsConstructor
public class ServiceOrderController {
    private final CreateServiceOrderUseCase createServiceOrderUseCase;
    private final CloseServiceOrderUseCase closeServiceOrderUseCase;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServiceOrderResponse create(@Valid @RequestBody CreateServiceOrderRequest request) {
        ServiceOrder serviceOrder = createServiceOrderUseCase.execute(
                request.getEquipment(),
                request.getTechnicianId(),
                request.getProblemDescription()
        );
        return ServiceOrderResponse.from(serviceOrder);
    }
    
    @PatchMapping("/{id}/close")
    public ServiceOrderResponse close(@PathVariable Long id) {
        ServiceOrder serviceOrder = closeServiceOrderUseCase.execute(id);
        return ServiceOrderResponse.from(serviceOrder);
    }
}