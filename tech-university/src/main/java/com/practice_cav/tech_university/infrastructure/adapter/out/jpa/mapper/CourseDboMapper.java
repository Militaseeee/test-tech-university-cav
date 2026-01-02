package com.practice_cav.tech_university.infrastructure.adapter.out.jpa.mapper;

import com.practice_cav.tech_university.domain.model.Course;
import com.practice_cav.tech_university.infrastructure.adapter.out.jpa.entity.CourseEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

// DBO -> Database Object
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CourseDboMapper {

    CourseEntity toDbo(Course domain);

    @InheritInverseConfiguration
    Course toDomain(CourseEntity dbo);
}