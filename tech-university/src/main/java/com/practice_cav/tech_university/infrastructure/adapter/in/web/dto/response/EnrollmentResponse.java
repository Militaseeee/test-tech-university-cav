package com.practice_cav.tech_university.infrastructure.adapter.in.web.dto.response;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class EnrollmentResponse {
    private Long id;
    private Long studentId;
    private String studentName;
    private String courseName;
    private LocalDateTime enrollmentDate;
}