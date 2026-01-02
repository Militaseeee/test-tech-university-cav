package com.practice_cav.tech_university.infrastructure.adapter.in.web.controller;

import com.practice_cav.tech_university.domain.port.in.enrollment.EnrollStudentUseCase;
import com.practice_cav.tech_university.infrastructure.adapter.in.web.dto.request.EnrollmentRequest;
import com.practice_cav.tech_university.infrastructure.adapter.in.web.dto.response.EnrollmentResponse;
import com.practice_cav.tech_university.infrastructure.adapter.in.web.mapper.EnrollmentWebMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollStudentUseCase enrollStudentUseCase;
    private final EnrollmentWebMapper enrollmentWebMapper;

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'ESTUDIANTE')")
    public ResponseEntity<EnrollmentResponse> enroll(@Valid @RequestBody EnrollmentRequest request) {
        var domain = enrollStudentUseCase.enroll(request.getStudentId(), request.getCourseId());
        return ResponseEntity.status(HttpStatus.CREATED).body(enrollmentWebMapper.toResponse(domain));
    }
}