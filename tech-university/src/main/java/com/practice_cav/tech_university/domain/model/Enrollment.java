package com.practice_cav.tech_university.domain.model;

import java.time.LocalDateTime;

public class Enrollment {
    private Long id;
    private Student student;
    private Course course;
    private LocalDateTime enrollmentDate;
    private String externalCheckId;

    public Enrollment() {
    }

    public Enrollment(Long id, Student student, Course course, LocalDateTime enrollmentDate, String externalCheckId) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.enrollmentDate = enrollmentDate;
        this.externalCheckId = externalCheckId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDateTime getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDateTime enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getExternalCheckId() {
        return externalCheckId;
    }

    public void setExternalCheckId(String externalCheckId) {
        this.externalCheckId = externalCheckId;
    }
}