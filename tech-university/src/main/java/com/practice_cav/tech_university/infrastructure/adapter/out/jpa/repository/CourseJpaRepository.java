package com.practice_cav.tech_university.infrastructure.adapter.out.jpa.repository;

import com.practice_cav.tech_university.infrastructure.adapter.out.jpa.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseJpaRepository extends JpaRepository<CourseEntity, Long> {
}