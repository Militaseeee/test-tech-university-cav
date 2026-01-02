package com.practice_cav.tech_university.domain.port.in.enrollment;

import com.practice_cav.tech_university.domain.model.Enrollment;

// proceso de matrícula
public interface EnrollStudentUseCase {
    Enrollment enroll(Long studentId, Long courseId);
}