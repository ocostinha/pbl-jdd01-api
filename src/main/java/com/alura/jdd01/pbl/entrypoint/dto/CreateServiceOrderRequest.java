package com.alura.jdd01.pbl.entrypoint.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateServiceOrderRequest {
    @NotBlank(message = "Equipamento é obrigatório")
    private String equipment;
    
    @NotNull(message = "Técnico é obrigatório")
    private Long technicianId;
    
    @NotBlank(message = "Descrição do problema é obrigatória")
    private String problemDescription;
}