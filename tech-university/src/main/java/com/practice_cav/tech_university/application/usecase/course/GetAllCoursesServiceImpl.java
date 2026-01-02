package com.practice_cav.tech_university.application.usecase.course;

import com.practice_cav.tech_university.domain.model.Course;
import com.practice_cav.tech_university.domain.port.in.course.GetAllCoursesUseCase;
import com.practice_cav.tech_university.domain.port.out.repository.CourseRepositoryPort;
import java.util.List;

public class GetAllCoursesServiceImpl implements GetAllCoursesUseCase {
    private final CourseRepositoryPort courseRepositoryPort;

    public GetAllCoursesServiceImpl(CourseRepositoryPort courseRepositoryPort) {
        this.courseRepositoryPort = courseRepositoryPort;
    }

    @Override
    public List<Course> findAll() {
        return courseRepositoryPort.findAll();
    }
}