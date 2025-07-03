package com.alura.jdd01.pbl.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "service_orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private LocalDateTime entryDate;
    
    private LocalDateTime exitDate;
    
    @Column(nullable = false)
    private String status;
    
    @Column(nullable = false)
    private String equipment;
    
    @Column(nullable = false)
    private Long technicianId;
    
    @Column(nullable = false, length = 1000)
    private String problemDescription;
}