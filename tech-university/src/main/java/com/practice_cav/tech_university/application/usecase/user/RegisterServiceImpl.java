package com.practice_cav.tech_university.application.usecase.user;

import com.practice_cav.tech_university.domain.exception.BusinessException;
import com.practice_cav.tech_university.domain.model.User;
import com.practice_cav.tech_university.domain.port.in.user.RegisterUseCase;
import com.practice_cav.tech_university.domain.port.out.repository.UserRepositoryPort;
import jakarta.transaction.Transactional;

public class RegisterServiceImpl implements RegisterUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public RegisterServiceImpl(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    @Transactional
    public User register(User user) {
        if (userRepositoryPort.findByEmail(user.getEmail()).isPresent()) {
            throw new BusinessException("El email ya está en uso");
        }
        return userRepositoryPort.save(user);
    }
}