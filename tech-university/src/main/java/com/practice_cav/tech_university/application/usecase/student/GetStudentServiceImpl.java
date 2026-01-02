package com.practice_cav.tech_university.application.usecase.student;

import com.practice_cav.tech_university.domain.exception.ResourceNotFoundException;
import com.practice_cav.tech_university.domain.model.Student;
import com.practice_cav.tech_university.domain.port.in.student.GetStudentUseCase;
import com.practice_cav.tech_university.domain.port.out.repository.StudentRepositoryPort;

import java.util.Optional;

public class GetStudentServiceImpl implements GetStudentUseCase {

    private final StudentRepositoryPort studentRepositoryPort;

    public GetStudentServiceImpl(StudentRepositoryPort studentRepositoryPort) {
        this.studentRepositoryPort = studentRepositoryPort;
    }

    @Override
    public Optional<Student> getById(Long id) {
        return Optional.ofNullable(studentRepositoryPort.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Estudiante con ID " + id + " no encontrado")));
    }

    @Override
    public Optional<Student> getByEmail(String email) {
        return studentRepositoryPort.findByEmail(email);
    }
}