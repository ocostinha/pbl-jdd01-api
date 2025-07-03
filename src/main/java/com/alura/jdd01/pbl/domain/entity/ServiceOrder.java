package com.alura.jdd01.pbl.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ServiceOrder {
    private final Long id;
    private final LocalDateTime entryDate;
    private final LocalDateTime exitDate;
    private final String status;
    private final String equipment;
    private final Long technicianId;
    private final String problemDescription;
    
    public static ServiceOrder create(String equipment, Long technicianId, String problemDescription) {
        validateEquipment(equipment);
        validateTechnicianId(technicianId);
        validateProblemDescription(problemDescription);
        
        return new ServiceOrder(
            null,
            LocalDateTime.now(),
            null,
            "ABERTO",
            equipment,
            technicianId,
            problemDescription
        );
    }
    
    public ServiceOrder close() {
        return new ServiceOrder(id, entryDate, LocalDateTime.now(), "FECHADO", equipment, technicianId, problemDescription);
    }
    
    private static void validateEquipment(String equipment) {
        if (equipment == null || equipment.trim().isEmpty()) {
            throw new IllegalArgumentException("Equipamento é obrigatório");
        }
    }
    
    private static void validateTechnicianId(Long technicianId) {
        if (technicianId == null) {
            throw new IllegalArgumentException("Técnico é obrigatório");
        }
    }
    
    private static void validateProblemDescription(String problemDescription) {
        if (problemDescription == null || problemDescription.trim().isEmpty()) {
            throw new IllegalArgumentException("Descrição do problema é obrigatória");
        }
    }
}