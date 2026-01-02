package com.practice_cav.tech_university.application.usecase.course;

import com.practice_cav.tech_university.domain.exception.ResourceNotFoundException;
import com.practice_cav.tech_university.domain.model.Course;
import com.practice_cav.tech_university.domain.port.in.course.GetCourseUseCase;
import com.practice_cav.tech_university.domain.port.out.repository.CourseRepositoryPort;
import java.util.Optional;

public class GetCourseServiceImpl implements GetCourseUseCase {
    private final CourseRepositoryPort courseRepositoryPort;

    public GetCourseServiceImpl(CourseRepositoryPort courseRepositoryPort) {
        this.courseRepositoryPort = courseRepositoryPort;
    }

    @Override
    public Optional<Course> getById(Long id) {
        return Optional.ofNullable(courseRepositoryPort.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso con ID " + id + " no encontrado")));
    }
}