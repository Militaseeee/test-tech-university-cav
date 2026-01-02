package com.practice_cav.tech_university.infrastructure.adapter.out.jpa.repository;

import com.practice_cav.tech_university.infrastructure.adapter.out.jpa.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface StudentJpaRepository extends JpaRepository<StudentEntity, Long> {
    Optional<StudentEntity> findByEmail(String email);
    Optional<StudentEntity> findByDocumentNumber(String documentNumber);
}