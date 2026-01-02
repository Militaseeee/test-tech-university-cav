package com.practice_cav.tech_university.domain.port.in.course;

import com.practice_cav.tech_university.domain.model.Course;
import java.util.List;

public interface GetAllCoursesUseCase {
    List<Course> findAll();
}