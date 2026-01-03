package com.practice_cav.tech_university.infrastructure.adapter.out.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

// relacion 1-1 guardaremos si el servicio externo la aprobó

@Entity
@Table(name = "enrollment_validations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnrollmentValidationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status; // APPROVED / REJECTED

    @Column(name = "external_check_id")
    private String externalCheckId; // Para trazabilidad
    private LocalDateTime validatedAt;
}