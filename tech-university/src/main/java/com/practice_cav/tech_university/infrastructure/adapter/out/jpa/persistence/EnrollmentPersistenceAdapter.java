package com.practice_cav.tech_university.infrastructure.adapter.out.jpa.persistence;

import com.practice_cav.tech_university.domain.model.Enrollment;
import com.practice_cav.tech_university.domain.port.out.repository.EnrollmentRepositoryPort;
import com.practice_cav.tech_university.infrastructure.adapter.out.jpa.mapper.EnrollmentDboMapper;
import com.practice_cav.tech_university.infrastructure.adapter.out.jpa.repository.EnrollmentJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EnrollmentPersistenceAdapter implements EnrollmentRepositoryPort {

    private final EnrollmentJpaRepository repository;
    private final EnrollmentDboMapper mapper;

    @Override
    public Enrollment save(Enrollment enrollment) {
        return mapper.toDomain(repository.save(mapper.toDbo(enrollment)));
    }

    @Override
    public List<Enrollment> findByStudentId(Long studentId) {
        return repository.findById(studentId).stream().map(mapper::toDomain).toList();
    }
}