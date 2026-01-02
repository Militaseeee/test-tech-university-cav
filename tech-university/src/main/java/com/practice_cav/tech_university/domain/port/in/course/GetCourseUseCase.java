package com.practice_cav.tech_university.domain.port.in.course;

import com.practice_cav.tech_university.domain.model.Course;
import java.util.Optional;

public interface GetCourseUseCase {
    Optional<Course> getById(Long id);
}