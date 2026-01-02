package com.practice_cav.tech_university.infrastructure.adapter.in.web.dto.response;

import lombok.Data;

@Data
public class StudentResponse {
    private Long id;
    private String name;
    private String email;
    private String documentNumber;
}