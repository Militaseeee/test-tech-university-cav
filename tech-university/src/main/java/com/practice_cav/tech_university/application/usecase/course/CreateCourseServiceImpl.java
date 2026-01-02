package com.practice_cav.tech_university.application.usecase.course;

import com.practice_cav.tech_university.domain.model.Course;
import com.practice_cav.tech_university.domain.port.in.course.CreateCourseUseCase;
import com.practice_cav.tech_university.domain.port.out.repository.CourseRepositoryPort;

public class CreateCourseServiceImpl implements CreateCourseUseCase {
    private final CourseRepositoryPort courseRepositoryPort;

    public CreateCourseServiceImpl(CourseRepositoryPort courseRepositoryPort) {
        this.courseRepositoryPort = courseRepositoryPort;
    }

    @Override
    public Course create(Course course) {
        return courseRepositoryPort.save(course);
    }
}