package com.practice_cav.tech_university.infrastructure.adapter.out.jpa.persistence;

import com.practice_cav.tech_university.domain.model.Enrollment;
import com.practice_cav.tech_university.domain.port.out.repository.EnrollmentRepositoryPort;
import com.practice_cav.tech_university.infrastructure.adapter.out.jpa.entity.EnrollmentEntity;
import com.practice_cav.tech_university.infrastructure.adapter.out.jpa.entity.EnrollmentValidationEntity;
import com.practice_cav.tech_university.infrastructure.adapter.out.jpa.mapper.EnrollmentDboMapper;
import com.practice_cav.tech_university.infrastructure.adapter.out.jpa.repository.EnrollmentJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class EnrollmentPersistenceAdapter implements EnrollmentRepositoryPort {

    private final EnrollmentJpaRepository repository;
    private final EnrollmentDboMapper mapper;

    @Override
    public Enrollment save(Enrollment enrollment) {

        // 1. Convertimos el dominio a Entity (la parte de matrícula)
        EnrollmentEntity entity = mapper.toDbo(enrollment);

        // 2. Creamos MANUALMENTE el objeto de validación para llenar la otra tabla
        EnrollmentValidationEntity validation = new EnrollmentValidationEntity();

        // Aquí usamos el ID que el Service le puso al dominio desde el Mock
        validation.setExternalCheckId(enrollment.getExternalCheckId());

        validation.setStatus("SUCCESS");
        validation.setValidatedAt(LocalDateTime.now());

        // 3. Metemos la validación dentro de la matrícula
        entity.setValidation(validation);

        // 4. Guardamos todo junto. El "Cascade.ALL" que tienes en la Entity
        // hace que JPA guarde primero la validación y luego la matrícula.
        EnrollmentEntity savedEntity = repository.save(entity);

        return mapper.toDomain(savedEntity);

        //return mapper.toDomain(repository.save(mapper.toDbo(enrollment)));
    }

    @Override
    public List<Enrollment> findByStudentId(Long studentId) {

        return repository.findAll().stream() // O una consulta personalizada en el JpaRepository
                .filter(e -> e.getStudent().getId().equals(studentId))
                .map(mapper::toDomain)
                .toList();

        //return repository.findById(studentId).stream().map(mapper::toDomain).toList();
    }
}