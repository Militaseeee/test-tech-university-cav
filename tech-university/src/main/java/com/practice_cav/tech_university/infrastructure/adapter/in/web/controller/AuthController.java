package com.practice_cav.tech_university.infrastructure.adapter.in.web.controller;

import com.practice_cav.tech_university.domain.model.User;
import com.practice_cav.tech_university.domain.port.in.user.LoginUseCase;
import com.practice_cav.tech_university.domain.port.in.user.RegisterUseCase;
import com.practice_cav.tech_university.infrastructure.adapter.in.web.dto.request.AuthRequest;
import com.practice_cav.tech_university.infrastructure.adapter.in.web.dto.request.RegisterRequest;
import com.practice_cav.tech_university.infrastructure.adapter.in.web.dto.response.AuthResponse;
import com.practice_cav.tech_university.infrastructure.adapter.in.web.mapper.UserWebMapper;
import com.practice_cav.tech_university.infrastructure.security.adapter.JwtTokenAdapter;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final LoginUseCase loginUseCase;
    private final RegisterUseCase registerUseCase;
    private final JwtTokenAdapter jwtService;
    private final UserWebMapper userWebMapper;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest request) {
        // Usamos el mapper para proteger el dominio
        User userToRegister = userWebMapper.toDomain(request);
        User registeredUser = registerUseCase.register(userToRegister);
        return ResponseEntity.ok(generateAuthResponse(registeredUser));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody AuthRequest request) {
        User user = loginUseCase.login(request.getEmail(), request.getPassword());
        return ResponseEntity.ok(generateAuthResponse(user));
    }

    private AuthResponse generateAuthResponse(User user) {
        String token = jwtService.generateToken(user.getEmail(), new HashMap<>());
        AuthResponse response = userWebMapper.toAuthResponse(user);
        response.setToken(token);
        return response;
    }
}