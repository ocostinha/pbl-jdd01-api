package com.alura.jdd01.pbl.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ServiceOrderJpaRepository extends JpaRepository<ServiceOrderEntity, Long> {
    List<ServiceOrderEntity> findByTechnicianId(Long technicianId);
}