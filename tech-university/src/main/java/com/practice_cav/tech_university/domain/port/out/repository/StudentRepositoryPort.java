package com.practice_cav.tech_university.domain.port.out.repository;

import com.practice_cav.tech_university.domain.model.Student;
import java.util.Optional;

public interface StudentRepositoryPort {
    Student save(Student student);
    Optional<Student> findByEmail(String email);
    Optional<Student> findById(Long id);
}