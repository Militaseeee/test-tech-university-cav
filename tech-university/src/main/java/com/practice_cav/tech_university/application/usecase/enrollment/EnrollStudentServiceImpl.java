package com.practice_cav.tech_university.application.usecase.enrollment;

import com.practice_cav.tech_university.domain.exception.BusinessException;
import com.practice_cav.tech_university.domain.exception.ResourceNotFoundException;
import com.practice_cav.tech_university.domain.model.Enrollment;
import com.practice_cav.tech_university.domain.model.Student;
import com.practice_cav.tech_university.domain.model.Course;
import com.practice_cav.tech_university.domain.port.in.enrollment.EnrollStudentUseCase;
import com.practice_cav.tech_university.domain.port.out.repository.CourseRepositoryPort;
import com.practice_cav.tech_university.domain.port.out.repository.EnrollmentRepositoryPort;
import com.practice_cav.tech_university.domain.port.out.repository.ExternalFinancyPort;
import com.practice_cav.tech_university.domain.port.out.repository.StudentRepositoryPort;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;

// este tenda tdo y el servicio externo
public class EnrollStudentServiceImpl implements EnrollStudentUseCase {

    private final EnrollmentRepositoryPort enrollmentRepositoryPort;
    private final StudentRepositoryPort studentRepositoryPort;
    private final CourseRepositoryPort courseRepositoryPort;
    private final ExternalFinancyPort externalFinancyPort;

    public EnrollStudentServiceImpl(EnrollmentRepositoryPort enrollmentRepositoryPort,
                                    StudentRepositoryPort studentRepositoryPort,
                                    CourseRepositoryPort courseRepositoryPort,
                                    ExternalFinancyPort externalFinancyPort) {
        this.enrollmentRepositoryPort = enrollmentRepositoryPort;
        this.studentRepositoryPort = studentRepositoryPort;
        this.courseRepositoryPort = courseRepositoryPort;
        this.externalFinancyPort = externalFinancyPort;
    }

    @Override
    @Transactional
    public Enrollment enroll(Long studentId, Long courseId) {
        // 1. Validar existencia del estudiante
        Student student = studentRepositoryPort.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("El estudiante no existe"));

        // 2. Validar existencia del curso
        Course course = courseRepositoryPort.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("El curso no existe"));

        // 3. REQUERIMIENTO: Validar deudas en el servicio externo (Mock)
        boolean hasDebt = externalFinancyPort.checkDebt(student.getDocumentNumber());
        if (hasDebt) {
            throw new BusinessException("Matrícula rechazada: El estudiante tiene deudas pendientes en el sistema financiero.");
        }

        // 4. Crear objeto de matrícula
        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setEnrollmentDate(LocalDateTime.now());

        // 5. Guardar
        return enrollmentRepositoryPort.save(enrollment);
    }
}