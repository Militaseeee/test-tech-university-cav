package com.practice_cav.tech_university.domain.port.out.repository;

import com.practice_cav.tech_university.domain.model.Enrollment;
import java.util.List;

public interface EnrollmentRepositoryPort {
    Enrollment save(Enrollment enrollment);
    List<Enrollment> findByStudentId(Long studentId);
}