package com.practice_cav.tech_university.infrastructure.adapter.in.web.mapper;

import com.practice_cav.tech_university.domain.model.Student;
import com.practice_cav.tech_university.infrastructure.adapter.in.web.dto.request.StudentRequest;
import com.practice_cav.tech_university.infrastructure.adapter.in.web.dto.response.StudentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StudentWebMapper {
    Student toDomain(StudentRequest request);
    StudentResponse toResponse(Student domain);
}