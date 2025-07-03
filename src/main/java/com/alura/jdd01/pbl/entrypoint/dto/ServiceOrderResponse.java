package com.alura.jdd01.pbl.entrypoint.dto;

import com.alura.jdd01.pbl.domain.entity.ServiceOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ServiceOrderResponse {
    private Long id;
    private LocalDateTime entryDate;
    private LocalDateTime exitDate;
    private String status;
    private String equipment;
    private Long technicianId;
    private String problemDescription;
    
    public static ServiceOrderResponse from(ServiceOrder serviceOrder) {
        return new ServiceOrderResponse(
                serviceOrder.getId(),
                serviceOrder.getEntryDate(),
                serviceOrder.getExitDate(),
                serviceOrder.getStatus(),
                serviceOrder.getEquipment(),
                serviceOrder.getTechnicianId(),
                serviceOrder.getProblemDescription()
        );
    }
}