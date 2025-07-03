package com.alura.jdd01.pbl.domain.repository;

import com.alura.jdd01.pbl.domain.entity.ServiceOrder;
import java.util.List;
import java.util.Optional;

public interface ServiceOrderRepository {
    ServiceOrder save(ServiceOrder serviceOrder);
    Optional<ServiceOrder> findById(Long id);
    List<ServiceOrder> findAll();
    List<ServiceOrder> findByTechnicianId(Long technicianId);
    void deleteById(Long id);
}