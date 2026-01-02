package com.practice_cav.tech_university.infrastructure.adapter.in.web.mapper;

import com.practice_cav.tech_university.domain.model.Course;
import com.practice_cav.tech_university.infrastructure.adapter.in.web.dto.request.CourseRequest;
import com.practice_cav.tech_university.infrastructure.adapter.in.web.dto.response.CourseResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CourseWebMapper {
    Course toDomain(CourseRequest request);
    CourseResponse toResponse(Course domain);
    List<CourseResponse> toResponseList(List<Course> domainList);
}