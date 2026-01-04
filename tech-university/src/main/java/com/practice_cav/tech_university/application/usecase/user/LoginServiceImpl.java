package com.practice_cav.tech_university.application.usecase.user;

import com.practice_cav.tech_university.domain.exception.BusinessException;
import com.practice_cav.tech_university.domain.model.User;
import com.practice_cav.tech_university.domain.port.in.user.LoginUseCase;
import com.practice_cav.tech_university.domain.port.out.repository.UserRepositoryPort;
import jakarta.transaction.Transactional;

public class LoginServiceImpl implements LoginUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public LoginServiceImpl(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    @Transactional
    public User login(String email, String password) {
        User user = userRepositoryPort.findByEmail(email)
                .orElseThrow(() -> new BusinessException("Usuario no encontrado"));

        if (!userRepositoryPort.authenticate(password, user.getPassword())) {
            throw new BusinessException("Contraseña incorrecta");
        }

        return user;
    }
}