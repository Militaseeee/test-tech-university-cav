package com.practice_cav.tech_university.infrastructure.adapter.in.web.controller;

import com.practice_cav.tech_university.domain.model.Course;
import com.practice_cav.tech_university.domain.port.in.course.CreateCourseUseCase;
import com.practice_cav.tech_university.domain.port.in.course.GetAllCoursesUseCase;
import com.practice_cav.tech_university.infrastructure.adapter.in.web.dto.request.CourseRequest;
import com.practice_cav.tech_university.infrastructure.adapter.in.web.dto.response.CourseResponse;
import com.practice_cav.tech_university.infrastructure.adapter.in.web.mapper.CourseWebMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CreateCourseUseCase createCourseUseCase;
    private final GetAllCoursesUseCase getAllCoursesUseCase;
    private final CourseWebMapper courseWebMapper;

    @PostMapping
    public ResponseEntity<CourseResponse> create(@Valid @RequestBody CourseRequest request) {
        Course course = createCourseUseCase.create(courseWebMapper.toDomain(request));
        return new ResponseEntity<>(courseWebMapper.toResponse(course), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CourseResponse>> getAll() {
        List<Course> courses = getAllCoursesUseCase.findAll();
        return ResponseEntity.ok(courseWebMapper.toResponseList(courses));
    }
}