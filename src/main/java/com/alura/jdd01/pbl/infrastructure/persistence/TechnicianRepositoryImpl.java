package com.alura.jdd01.pbl.infrastructure.persistence;

import com.alura.jdd01.pbl.domain.entity.Technician;
import com.alura.jdd01.pbl.domain.repository.TechnicianRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TechnicianRepositoryImpl implements TechnicianRepository {
    private final TechnicianJpaRepository jpaRepository;
    
    @Override
    public Technician save(Technician technician) {
        TechnicianEntity entity = toEntity(technician);
        TechnicianEntity saved = jpaRepository.save(entity);
        return toDomain(saved);
    }
    
    @Override
    public Optional<Technician> findById(Long id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }
    
    @Override
    public List<Technician> findAll() {
        return jpaRepository.findAll().stream()
                .map(this::toDomain)
                .toList();
    }
    
    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
    
    private TechnicianEntity toEntity(Technician technician) {
        return new TechnicianEntity(technician.getId(), technician.getName(), 
                technician.getEmail(), technician.getPhone());
    }
    
    private Technician toDomain(TechnicianEntity entity) {
        return new Technician(entity.getId(), entity.getName(), 
                entity.getEmail(), entity.getPhone());
    }
}