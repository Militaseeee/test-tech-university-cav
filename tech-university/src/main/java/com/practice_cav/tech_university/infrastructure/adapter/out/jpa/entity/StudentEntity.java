package com.practice_cav.tech_university.infrastructure.adapter.out.jpa.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "students")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String documentNumber;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<EnrollmentEntity> enrollments;
}