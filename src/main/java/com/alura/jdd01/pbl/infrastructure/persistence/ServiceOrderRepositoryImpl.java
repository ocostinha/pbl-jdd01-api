package com.alura.jdd01.pbl.infrastructure.persistence;

import com.alura.jdd01.pbl.domain.entity.ServiceOrder;
import com.alura.jdd01.pbl.domain.repository.ServiceOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ServiceOrderRepositoryImpl implements ServiceOrderRepository {
    private final ServiceOrderJpaRepository jpaRepository;
    
    @Override
    public ServiceOrder save(ServiceOrder serviceOrder) {
        ServiceOrderEntity entity = toEntity(serviceOrder);
        ServiceOrderEntity saved = jpaRepository.save(entity);
        return toDomain(saved);
    }
    
    @Override
    public Optional<ServiceOrder> findById(Long id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }
    
    @Override
    public List<ServiceOrder> findAll() {
        return jpaRepository.findAll().stream()
                .map(this::toDomain)
                .toList();
    }
    
    @Override
    public List<ServiceOrder> findByTechnicianId(Long technicianId) {
        return jpaRepository.findByTechnicianId(technicianId).stream()
                .map(this::toDomain)
                .toList();
    }
    
    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
    
    private ServiceOrderEntity toEntity(ServiceOrder serviceOrder) {
        return new ServiceOrderEntity(
                serviceOrder.getId(),
                serviceOrder.getEntryDate(),
                serviceOrder.getExitDate(),
                serviceOrder.getStatus(),
                serviceOrder.getEquipment(),
                serviceOrder.getTechnicianId(),
                serviceOrder.getProblemDescription()
        );
    }
    
    private ServiceOrder toDomain(ServiceOrderEntity entity) {
        return new ServiceOrder(
                entity.getId(),
                entity.getEntryDate(),
                entity.getExitDate(),
                entity.getStatus(),
                entity.getEquipment(),
                entity.getTechnicianId(),
                entity.getProblemDescription()
        );
    }
}