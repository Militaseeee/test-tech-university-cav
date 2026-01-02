package com.practice_cav.tech_university.domain.port.in.student;

import com.practice_cav.tech_university.domain.model.Student;

public interface UpdateStudentUseCase {
    Student update(Long id, Student student);
}