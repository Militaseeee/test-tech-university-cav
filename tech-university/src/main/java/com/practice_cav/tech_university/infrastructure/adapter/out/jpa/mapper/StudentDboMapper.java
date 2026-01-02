package com.practice_cav.tech_university.infrastructure.adapter.out.jpa.mapper;

import com.practice_cav.tech_university.domain.model.Student;
import com.practice_cav.tech_university.infrastructure.adapter.out.jpa.entity.StudentEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StudentDboMapper {

    // Si los nombres de los campos son iguales, MapStruct los hace solos.
    // Ignoramos la lista de matrículas en el mapeo simple para evitar ciclos.
    @Mapping(target = "enrollments", ignore = true)
    StudentEntity toDbo(Student domain);

    @InheritInverseConfiguration
    Student toDomain(StudentEntity dbo);
}