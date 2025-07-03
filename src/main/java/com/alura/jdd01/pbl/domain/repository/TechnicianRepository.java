package com.alura.jdd01.pbl.domain.repository;

import com.alura.jdd01.pbl.domain.entity.Technician;
import java.util.List;
import java.util.Optional;

public interface TechnicianRepository {
    Technician save(Technician technician);
    Optional<Technician> findById(Long id);
    List<Technician> findAll();
    void deleteById(Long id);
}