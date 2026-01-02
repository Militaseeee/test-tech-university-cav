package com.practice_cav.tech_university.domain.port.out.repository;

import com.practice_cav.tech_university.domain.model.User;
import java.util.Optional;

public interface UserRepositoryPort {
    User save(User user);
    Optional<User> findByEmail(String email);
    // Aquí es donde la infra implementará la lógica de "autenticar" contra el password encriptado
    boolean authenticate(String rawPassword, String encodedPassword);
}