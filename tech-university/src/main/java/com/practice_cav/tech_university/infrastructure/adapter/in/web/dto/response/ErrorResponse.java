package com.practice_cav.tech_university.infrastructure.adapter.in.web.dto.response;

import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Builder
public class ErrorResponse {
    private String type;        // URI que identifica el tipo de error
    private String title;       // Breve resumen del error
    private int status;         // Código HTTP
    private String detail;      // Explicación detallada
    private String instance;    // URI de la petición que falló
    private LocalDateTime timestamp;
    private Map<String, String> errors; // Para Bean Validation (campo: error)
}