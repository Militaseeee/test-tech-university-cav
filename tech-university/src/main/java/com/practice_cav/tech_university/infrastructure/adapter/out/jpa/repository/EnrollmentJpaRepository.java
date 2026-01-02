package com.practice_cav.tech_university.infrastructure.adapter.out.jpa.repository;

import com.practice_cav.tech_university.infrastructure.adapter.out.jpa.entity.EnrollmentEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnrollmentJpaRepository extends JpaRepository<EnrollmentEntity, Long> {

    @EntityGraph(attributePaths = {"student", "course"})
    List<EnrollmentEntity> findAll();
    // Esto trae todo en una sola consulta JOIN, evitando el N+1

    @EntityGraph(attributePaths = {"student", "course"})
    Optional<EnrollmentEntity> findById(Long id);
}