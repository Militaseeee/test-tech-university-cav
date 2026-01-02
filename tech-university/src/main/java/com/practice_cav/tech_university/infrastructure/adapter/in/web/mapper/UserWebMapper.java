package com.practice_cav.tech_university.infrastructure.adapter.in.web.mapper;

import com.practice_cav.tech_university.domain.model.User;
import com.practice_cav.tech_university.infrastructure.adapter.in.web.dto.request.RegisterRequest;
import com.practice_cav.tech_university.infrastructure.adapter.in.web.dto.response.AuthResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserWebMapper {

    // Convierte lo que llega de la web al dominio
    User toDomain(RegisterRequest request);

    // Convierte el dominio a la respuesta de la web
    @Mapping(target = "token", ignore = true)
    AuthResponse toAuthResponse(User domain);
}