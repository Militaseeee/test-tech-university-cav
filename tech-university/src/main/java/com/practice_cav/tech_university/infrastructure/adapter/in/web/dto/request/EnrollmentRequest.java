package com.practice_cav.tech_university.infrastructure.adapter.in.web.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnrollmentRequest {
    @NotNull(message = "El ID del estudiante es obligatorio")
    private Long studentId;

    @NotNull(message = "El ID del curso es obligatorio")
    private Long courseId;
}