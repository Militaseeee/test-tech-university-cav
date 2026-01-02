package com.practice_cav.tech_university.domain.port.in.user;

import com.practice_cav.tech_university.domain.model.User;

public interface RegisterUseCase {
    User register(User user);
}