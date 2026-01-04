package com.practice_cav.tech_university.application.usecase.enrollment;

import com.practice_cav.tech_university.domain.exception.BusinessException;
import com.practice_cav.tech_university.domain.exception.ResourceNotFoundException;
import com.practice_cav.tech_university.domain.model.*;
import com.practice_cav.tech_university.domain.port.out.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EnrollStudentServiceImplTest {

    @Mock
    private EnrollmentRepositoryPort enrollmentRepository;
    @Mock
    private StudentRepositoryPort studentRepository;
    @Mock
    private CourseRepositoryPort courseRepository;
    @Mock
    private ExternalFinancyPort externalFinancyPort;

    @InjectMocks
    private EnrollStudentServiceImpl useCase;

    private Student student;
    private Course course;

    @BeforeEach
    void setUp() {
        student = new Student();
        student.setId(1L);
        student.setDocumentNumber("10101010");

        course = new Course();
        course.setId(1L);
        course.setName("Arquitectura Hexagonal");
    }

    @Test
    void shouldEnrollSuccessfully_WhenNoDebt() {
        // GIVEN
        FinancyStatus status = new FinancyStatus(false, "UUID-VALID-123");

        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));
        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));
        when(externalFinancyPort.checkDebt(anyString())).thenReturn(status);
        when(enrollmentRepository.save(any(Enrollment.class))).thenAnswer(i -> i.getArguments()[0]);

        // WHEN
        Enrollment result = useCase.enroll(1L, 1L);

        // THEN
        assertNotNull(result);
        assertEquals("UUID-VALID-123", result.getExternalCheckId());
        verify(enrollmentRepository).save(any(Enrollment.class));
    }

    @Test
    void shouldThrowException_WhenStudentHasDebt() {
        // GIVEN
        FinancyStatus status = new FinancyStatus(true, "DEBT-ID-666");

        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));
        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));
        when(externalFinancyPort.checkDebt(anyString())).thenReturn(status);

        // WHEN & THEN
        BusinessException exception = assertThrows(BusinessException.class, () -> {
            useCase.enroll(1L, 1L);
        });

        assertTrue(exception.getMessage().contains("deudas pendientes"));
        verify(enrollmentRepository, never()).save(any());
    }

    @Test
    void shouldThrowNotFound_WhenStudentDoesNotExist() {
        // GIVEN
        when(studentRepository.findById(1L)).thenReturn(Optional.ofNullable(null));

        // WHEN & THEN
        assertThrows(ResourceNotFoundException.class, () -> {
            useCase.enroll(1L, 1L);
        });
    }
}