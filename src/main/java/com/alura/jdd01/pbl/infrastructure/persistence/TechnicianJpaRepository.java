package com.alura.jdd01.pbl.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnicianJpaRepository extends JpaRepository<TechnicianEntity, Long> {
}