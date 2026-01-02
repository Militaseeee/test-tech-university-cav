package com.practice_cav.tech_university.infrastructure.adapter.in.web.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CourseRequest {
    @NotBlank(message = "El nombre del curso es obligatorio")
    private String name;

    private String description;

    private int credits;
}