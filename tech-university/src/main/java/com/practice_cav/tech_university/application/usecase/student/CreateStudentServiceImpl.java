package com.practice_cav.tech_university.application.usecase.student;

import com.practice_cav.tech_university.domain.exception.BusinessException;
import com.practice_cav.tech_university.domain.model.Student;
import com.practice_cav.tech_university.domain.port.in.student.CreateStudentUseCase;
import com.practice_cav.tech_university.domain.port.out.repository.StudentRepositoryPort;

public class CreateStudentServiceImpl implements CreateStudentUseCase {

    private final StudentRepositoryPort studentRepositoryPort;

    // Inyección por constructor (cumpliendo con la inversión de dependencia)
    public CreateStudentServiceImpl(StudentRepositoryPort studentRepositoryPort) {
        this.studentRepositoryPort = studentRepositoryPort;
    }

    @Override
    public Student create(Student student) {
        // Validamos si el email ya existe antes de guardar
        if (studentRepositoryPort.findByEmail(student.getEmail()).isPresent()) {
            throw new BusinessException("El correo electrónico " + student.getEmail() + " ya está registrado.");
        }

        // Aquí podrías agregar más lógica, como encriptar la contraseña
        // (aunque eso suele delegarse a un puerto de seguridad)

        return studentRepositoryPort.save(student);
    }
}