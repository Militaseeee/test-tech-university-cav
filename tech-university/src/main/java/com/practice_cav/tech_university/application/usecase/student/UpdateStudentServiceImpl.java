package com.practice_cav.tech_university.application.usecase.student;

import com.practice_cav.tech_university.domain.exception.ResourceNotFoundException;
import com.practice_cav.tech_university.domain.model.Student;
import com.practice_cav.tech_university.domain.port.in.student.UpdateStudentUseCase;
import com.practice_cav.tech_university.domain.port.out.repository.StudentRepositoryPort;

public class UpdateStudentServiceImpl implements UpdateStudentUseCase {

    private final StudentRepositoryPort studentRepositoryPort;

    public UpdateStudentServiceImpl(StudentRepositoryPort studentRepositoryPort) {
        this.studentRepositoryPort = studentRepositoryPort;
    }

    @Override
    public Student update(Long id, Student student) {
        // 1. Validar que el estudiante existe
        return studentRepositoryPort.findById(id)
                .map(existingStudent -> {
                    // 2. Actualizar campos (puedes elegir cuáles permitir)
                    existingStudent.setFirstName(student.getFirstName());
                    existingStudent.setLastName(student.getLastName());
                    existingStudent.setEmail(student.getEmail());
                    // No solemos actualizar el password aquí por seguridad
                    return studentRepositoryPort.save(existingStudent);
                })
                .orElseThrow(() -> new ResourceNotFoundException("No se puede actualizar: Estudiante con ID " + id + " no encontrado"));
    }
}