package com.practice_cav.tech_university.infrastructure.adapter.out.jpa.mapper;

import com.practice_cav.tech_university.domain.model.User;
import com.practice_cav.tech_university.infrastructure.adapter.out.jpa.entity.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserDboMapper {

    UserEntity toDbo(User domain);

    @InheritInverseConfiguration
    User toDomain(UserEntity dbo);
}