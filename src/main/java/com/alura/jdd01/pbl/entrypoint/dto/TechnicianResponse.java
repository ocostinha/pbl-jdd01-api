package com.alura.jdd01.pbl.entrypoint.dto;

import com.alura.jdd01.pbl.domain.entity.Technician;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TechnicianResponse {
    private Long id;
    private String name;
    private String email;
    private String phone;
    
    public static TechnicianResponse from(Technician technician) {
        return new TechnicianResponse(
                technician.getId(),
                technician.getName(),
                technician.getEmail(),
                technician.getPhone()
        );
    }
}