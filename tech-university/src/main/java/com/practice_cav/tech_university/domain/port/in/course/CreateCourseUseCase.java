package com.practice_cav.tech_university.domain.port.in.course;

import com.practice_cav.tech_university.domain.model.Course;

public interface CreateCourseUseCase {
    Course create(Course course);
}