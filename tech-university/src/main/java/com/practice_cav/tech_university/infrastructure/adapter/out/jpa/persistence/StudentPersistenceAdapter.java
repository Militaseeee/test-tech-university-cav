package com.practice_cav.tech_university.infrastructure.adapter.out.jpa.persistence;

import com.practice_cav.tech_university.domain.model.Student;
import com.practice_cav.tech_university.domain.port.out.repository.StudentRepositoryPort;
import com.practice_cav.tech_university.infrastructure.adapter.out.jpa.mapper.StudentDboMapper;
import com.practice_cav.tech_university.infrastructure.adapter.out.jpa.repository.StudentJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StudentPersistenceAdapter implements StudentRepositoryPort {

    private final StudentJpaRepository repository;
    private final StudentDboMapper mapper;

    @Override
    public Student save(Student student) {
        return mapper.toDomain(repository.save(mapper.toDbo(student)));
    }

    @Override
    public Optional<Student> findByEmail(String email) {
        return repository.findByEmail(email).map(mapper::toDomain);
    }

    @Override
    public Optional<Student> findById(Long id) {
        return repository.findById(id).map(mapper::toDomain);
    }
}