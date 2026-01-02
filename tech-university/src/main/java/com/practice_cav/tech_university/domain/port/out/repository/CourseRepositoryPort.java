package com.practice_cav.tech_university.domain.port.out.repository;

import com.practice_cav.tech_university.domain.model.Course;
import java.util.List;
import java.util.Optional;

public interface CourseRepositoryPort {
    Course save(Course course);
    Optional<Course> findById(Long id);
    List<Course> findAll();
}