package com.practice_cav.tech_university.domain.port.in.student;

import com.practice_cav.tech_university.domain.model.Student;
import java.util.Optional;

public interface GetStudentUseCase {
    Optional<Student> getById(Long id);
    Optional<Student> getByEmail(String email);
}