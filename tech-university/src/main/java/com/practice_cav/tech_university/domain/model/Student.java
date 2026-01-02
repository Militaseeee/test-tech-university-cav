package com.practice_cav.tech_university.domain.model;

import java.util.List;

public class Student {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String documentNumber; // Para validar deudas en el Mock
    private String password;       // Para el login
    private Role role;         // ADMIN o ESTUDIANTE
    private List<Course> enrolledCourses;

    public Student() {
    }

    public Student(Long id, String firstName, String lastName, String email, String documentNumber, String password, Role role, List<Course> enrolledCourses) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.documentNumber = documentNumber;
        this.password = password;
        this.role = role;
        this.enrolledCourses = enrolledCourses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }
}
