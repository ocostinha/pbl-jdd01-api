package com.alura.jdd01.pbl.entrypoint.controller;

import com.alura.jdd01.pbl.domain.entity.ServiceOrder;
import com.alura.jdd01.pbl.entrypoint.dto.CreateServiceOrderRequest;
import com.alura.jdd01.pbl.entrypoint.dto.UpdateServiceOrderRequest;
import com.alura.jdd01.pbl.entrypoint.dto.ServiceOrderResponse;
import com.alura.jdd01.pbl.usecase.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/service-orders")
@RequiredArgsConstructor
public class ServiceOrderController {
    private final CreateServiceOrderUseCase createServiceOrderUseCase;
    private final CloseServiceOrderUseCase closeServiceOrderUseCase;
    private final FindServiceOrderByIdUseCase findServiceOrderByIdUseCase;
    private final FindAllServiceOrdersUseCase findAllServiceOrdersUseCase;
    private final UpdateServiceOrderUseCase updateServiceOrderUseCase;
    private final DeleteServiceOrderUseCase deleteServiceOrderUseCase;
    
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
    
    @GetMapping
    public List<ServiceOrderResponse> findAll() {
        return findAllServiceOrdersUseCase.execute().stream()
                .map(ServiceOrderResponse::from)
                .toList();
    }
    
    @GetMapping("/{id}")
    public ServiceOrderResponse findById(@PathVariable Long id) {
        ServiceOrder serviceOrder = findServiceOrderByIdUseCase.execute(id);
        return ServiceOrderResponse.from(serviceOrder);
    }
    
    @PutMapping("/{id}")
    public ServiceOrderResponse update(@PathVariable Long id, @Valid @RequestBody UpdateServiceOrderRequest request) {
        ServiceOrder serviceOrder = updateServiceOrderUseCase.execute(
                id,
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
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        deleteServiceOrderUseCase.execute(id);
    }
}