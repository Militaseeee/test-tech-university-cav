package com.practice_cav.tech_university.domain.port.out.security;

import com.practice_cav.tech_university.domain.model.User;

public interface TokenProviderPort {
    String generateToken(User user);
    String getUsernameFromToken(String token);
    boolean isTokenValid(String token, String username);
}