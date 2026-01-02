package com.practice_cav.tech_university.infrastructure.adapter.in.web.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthResponse {
    private String email;
    private String role;
    private String token;
}