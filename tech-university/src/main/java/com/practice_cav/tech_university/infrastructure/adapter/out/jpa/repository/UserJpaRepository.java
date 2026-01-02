package com.practice_cav.tech_university.infrastructure.adapter.out.jpa.repository;

import com.practice_cav.tech_university.infrastructure.adapter.out.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}