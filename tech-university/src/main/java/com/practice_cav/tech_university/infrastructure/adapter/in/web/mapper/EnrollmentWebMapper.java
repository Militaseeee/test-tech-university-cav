package com.practice_cav.tech_university.infrastructure.adapter.in.web.mapper;

import com.practice_cav.tech_university.domain.model.Enrollment;
import com.practice_cav.tech_university.infrastructure.adapter.in.web.dto.response.EnrollmentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EnrollmentWebMapper {

    @Mapping(target = "studentId", source = "student.id")
    @Mapping(target = "studentName", expression = "java(domain.getStudent().getFirstName() + ' ' + domain.getStudent().getLastName())")
    @Mapping(target = "courseName", source = "course.name")
    EnrollmentResponse toResponse(Enrollment domain);
}