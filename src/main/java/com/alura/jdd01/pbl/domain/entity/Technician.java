package com.alura.jdd01.pbl.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Technician {
    private final Long id;
    private final String name;
    private final String email;
    private final String phone;
    
    public static Technician create(String name, String email, String phone) {
        validateName(name);
        validateEmail(email);
        validatePhone(phone);
        return new Technician(null, name, email, phone);
    }
    
    private static void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }
    }
    
    private static void validateEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email inválido");
        }
    }
    
    private static void validatePhone(String phone) {
        if (phone == null || phone.trim().isEmpty()) {
            throw new IllegalArgumentException("Telefone é obrigatório");
        }
    }
}