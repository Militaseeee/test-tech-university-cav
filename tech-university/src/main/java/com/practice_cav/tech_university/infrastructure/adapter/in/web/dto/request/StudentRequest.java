package com.practice_cav.tech_university.infrastructure.adapter.in.web.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class StudentRequest {
    @NotBlank(message = "El nombre es obligatorio")
    private String name;

    @Email(message = "Email inválido")
    @NotBlank(message = "El email es obligatorio")
    private String email;

    @NotBlank(message = "El número de documento es obligatorio")
    private String documentNumber; // Este es el que usará Feign para consultar la deuda
}