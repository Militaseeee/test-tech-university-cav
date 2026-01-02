package com.practice_cav.tech_university.domain.port.in.user;

import com.practice_cav.tech_university.domain.model.User;

public interface LoginUseCase {
    // Retornamos el User autenticado (luego el Service le pondrá el Token en Infra)
    User login(String email, String password);
}