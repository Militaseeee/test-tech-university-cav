package com.practice_cav.tech_university.infrastructure.adapter.out.jpa.persistence;

import com.practice_cav.tech_university.domain.model.User;
import com.practice_cav.tech_university.domain.port.out.repository.UserRepositoryPort;
import com.practice_cav.tech_university.infrastructure.adapter.out.jpa.mapper.UserDboMapper;
import com.practice_cav.tech_university.infrastructure.adapter.out.jpa.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserRepositoryPort {

    private final UserJpaRepository repository;
    private final UserDboMapper mapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User save(User user) {
        // Encriptamos antes de guardar en la DB
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return mapper.toDomain(repository.save(mapper.toDbo(user)));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email).map(mapper::toDomain);
    }

    // Cambiamos 'matches' por 'authenticate' para que coincida con el puerto
    @Override
    public boolean authenticate(String rawPassword, String encodedPassword) {
        // Usamos el passwordEncoder para comparar la clave plana vs la encriptada
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}