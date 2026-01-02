package com.practice_cav.tech_university.infrastructure.adapter.in.web.controller;

import com.practice_cav.tech_university.domain.model.Enrollment;
import com.practice_cav.tech_university.domain.model.Student;
import com.practice_cav.tech_university.domain.port.in.enrollment.EnrollStudentUseCase;
import com.practice_cav.tech_university.domain.port.in.student.*;
import com.practice_cav.tech_university.infrastructure.adapter.in.web.dto.request.StudentRequest;
import com.practice_cav.tech_university.infrastructure.adapter.in.web.dto.response.StudentResponse;
import com.practice_cav.tech_university.infrastructure.adapter.in.web.mapper.StudentWebMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final CreateStudentUseCase createStudentUseCase;
    private final GetStudentUseCase getStudentUseCase;
    private final EnrollStudentUseCase enrollStudentUseCase;
    private final StudentWebMapper studentWebMapper;

    @PostMapping
    public ResponseEntity<StudentResponse> create(@Valid @RequestBody StudentRequest request) {
        Student student = createStudentUseCase.create(studentWebMapper.toDomain(request));
        return new ResponseEntity<>(studentWebMapper.toResponse(student), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getById(@PathVariable Long id) {
        Student student = getStudentUseCase.getById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con ID: " + id));

        return ResponseEntity.ok(studentWebMapper.toResponse(student));
    }

    // Matrícula
    @PostMapping("/{studentId}/enroll/{courseId}")
    public ResponseEntity<String> enroll(@PathVariable Long studentId, @PathVariable Long courseId) {
        // Esta llamada viajará por el UseCase, llegará al adaptador de Feign,
        // consultará el Mock y decidirá si permite la matrícula.
        enrollStudentUseCase.enroll(studentId, courseId);
        return ResponseEntity.ok("Estudiante matriculado exitosamente");
    }
}