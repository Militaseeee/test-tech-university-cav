package com.practice_cav.tech_university.domain.port.in.student;

import com.practice_cav.tech_university.domain.model.Student;

public interface CreateStudentUseCase {
    Student create(Student student);
}