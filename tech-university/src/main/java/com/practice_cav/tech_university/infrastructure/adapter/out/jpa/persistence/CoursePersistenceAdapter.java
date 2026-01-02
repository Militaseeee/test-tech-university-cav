package com.practice_cav.tech_university.infrastructure.adapter.out.jpa.persistence;

import com.practice_cav.tech_university.domain.model.Course;
import com.practice_cav.tech_university.domain.port.out.repository.CourseRepositoryPort;
import com.practice_cav.tech_university.infrastructure.adapter.out.jpa.mapper.CourseDboMapper;
import com.practice_cav.tech_university.infrastructure.adapter.out.jpa.repository.CourseJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CoursePersistenceAdapter implements CourseRepositoryPort {

    private final CourseJpaRepository repository;
    private final CourseDboMapper mapper;

    @Override
    public Course save(Course course) {
        return mapper.toDomain(repository.save(mapper.toDbo(course)));
    }

    @Override
    public Optional<Course> findById(Long id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Course> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }
}