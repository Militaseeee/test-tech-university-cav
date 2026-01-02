package com.practice_cav.tech_university.infrastructure.config;

import com.practice_cav.tech_university.application.usecase.course.*;
import com.practice_cav.tech_university.application.usecase.enrollment.*;
import com.practice_cav.tech_university.application.usecase.student.*;
import com.practice_cav.tech_university.application.usecase.user.*;
import com.practice_cav.tech_university.domain.port.in.course.*;
import com.practice_cav.tech_university.domain.port.in.enrollment.*;
import com.practice_cav.tech_university.domain.port.in.student.*;
import com.practice_cav.tech_university.domain.port.in.user.*;
import com.practice_cav.tech_university.domain.port.out.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    // --- BEANS DE ESTUDIANTE ---
    @Bean
    public CreateStudentUseCase createStudentUseCase(StudentRepositoryPort repository) {
        return new CreateStudentServiceImpl(repository);
    }

    @Bean
    public GetStudentUseCase getStudentUseCase(StudentRepositoryPort repository) {
        return new GetStudentServiceImpl(repository);
    }

    @Bean
    public UpdateStudentUseCase updateStudentUseCase(StudentRepositoryPort repository) {
        return new UpdateStudentServiceImpl(repository);
    }

    // --- BEANS DE CURSO ---
    @Bean
    public CreateCourseUseCase createCourseUseCase(CourseRepositoryPort repository) {
        return new CreateCourseServiceImpl(repository);
    }

    @Bean
    public GetAllCoursesUseCase getAllCoursesUseCase(CourseRepositoryPort repository) {
        return new GetAllCoursesServiceImpl(repository);
    }

    @Bean
    public GetCourseUseCase getCourseUseCase(CourseRepositoryPort repository) {
        return new GetCourseServiceImpl(repository);
    }

    // --- BEANS DE USUARIO (AUTH) ---
    @Bean
    public LoginUseCase loginUseCase(UserRepositoryPort repository) {
        return new LoginServiceImpl(repository);
    }

    @Bean
    public RegisterUseCase registerUseCase(UserRepositoryPort repository) {
        return new RegisterServiceImpl(repository);
    }

    // --- BEAN DE MATRÍCULA (EL MÁS COMPLETO) ---
    @Bean
    public EnrollStudentUseCase enrollStudentUseCase(
            EnrollmentRepositoryPort enrollmentRepo,
            StudentRepositoryPort studentRepo,
            CourseRepositoryPort courseRepo,
            ExternalFinancyPort financyPort) {
        return new EnrollStudentServiceImpl(enrollmentRepo, studentRepo, courseRepo, financyPort);
    }
}