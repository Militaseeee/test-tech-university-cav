package com.practice_cav.tech_university.infrastructure.adapter.out.jpa.repository;

import com.practice_cav.tech_university.infrastructure.adapter.out.jpa.entity.EnrollmentEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnrollmentJpaRepository extends JpaRepository<EnrollmentEntity, Long> {

    @EntityGraph(attributePaths = {"student", "course", "validation"})
    List<EnrollmentEntity> findAll();

    @EntityGraph(attributePaths = {"student", "course", "validation"})
    Optional<EnrollmentEntity> findById(Long id);
}