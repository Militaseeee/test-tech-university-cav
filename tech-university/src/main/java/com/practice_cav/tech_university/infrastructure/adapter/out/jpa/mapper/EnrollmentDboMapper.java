package com.practice_cav.tech_university.infrastructure.adapter.out.jpa.mapper;

import com.practice_cav.tech_university.domain.model.Enrollment;
import com.practice_cav.tech_university.infrastructure.adapter.out.jpa.entity.EnrollmentEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EnrollmentDboMapper {

    @Mapping(target = "validation", ignore = true)
    EnrollmentEntity toDbo(Enrollment domain);

    Enrollment toDomain(EnrollmentEntity dbo);
}