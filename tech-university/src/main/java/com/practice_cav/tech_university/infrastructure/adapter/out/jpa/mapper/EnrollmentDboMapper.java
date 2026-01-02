package com.practice_cav.tech_university.infrastructure.adapter.out.jpa.mapper;

import com.practice_cav.tech_university.domain.model.Enrollment;
import com.practice_cav.tech_university.infrastructure.adapter.out.jpa.entity.EnrollmentEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {StudentDboMapper.class, CourseDboMapper.class})
public interface EnrollmentDboMapper {

    EnrollmentEntity toDbo(Enrollment domain);

    @InheritInverseConfiguration
    Enrollment toDomain(EnrollmentEntity dbo);
}