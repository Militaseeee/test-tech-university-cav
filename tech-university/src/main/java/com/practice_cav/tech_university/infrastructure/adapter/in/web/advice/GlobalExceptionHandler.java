package com.practice_cav.tech_university.infrastructure.adapter.in.web.advice;

import com.practice_cav.tech_university.domain.exception.BusinessException;
import com.practice_cav.tech_university.domain.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.net.URI;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j // OBLIGATORIO: Logging estructurado
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Método privado para evitar repetir código y cumplir con el estándar
    private ProblemDetail buildProblemDetail(HttpStatus status, String detail, String title, String type, WebRequest request) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(status, detail);
        problem.setTitle(title);
        problem.setType(URI.create(type));
        problem.setInstance(URI.create(request.getDescription(false).replace("uri=", "")));

        // Requerimientos Senior: Be a coder
        problem.setProperty("timestamp", Instant.now());
        problem.setProperty("traceId", UUID.randomUUID().toString()); // Identificador único para rastrear el error en logs

        return problem;
    }

    @ExceptionHandler(BusinessException.class)
    public ProblemDetail handleBusiness(BusinessException ex, WebRequest request) {
        log.error("Error de negocio detectado: {}", ex.getMessage());
        return buildProblemDetail(HttpStatus.BAD_REQUEST, ex.getMessage(), "Conflicto de Negocio", "/errors/business-logic", request);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ProblemDetail handleNotFound(ResourceNotFoundException ex, WebRequest request) {
        log.warn("Recurso no encontrado: {}", ex.getMessage());
        return buildProblemDetail(HttpStatus.NOT_FOUND, ex.getMessage(), "No Encontrado", "/errors/not-found", request);
    }

    // OBLIGATORIO: Validación avanzada (Bean Validation)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleValidation(MethodArgumentNotValidException ex, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(f -> errors.put(f.getField(), f.getDefaultMessage()));

        log.warn("Error de validación en la petición: {}", errors);

        ProblemDetail problem = buildProblemDetail(HttpStatus.BAD_REQUEST, "Los datos enviados no son válidos", "Error de Validación", "/errors/validation", request);
        problem.setProperty("errors", errors); // Aquí mostramos qué campos fallaron
        return problem;
    }

    // OBLIGATORIO: Errores de JPA / Integridad (Ej: Documento duplicado)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ProblemDetail handleJpaError(DataIntegrityViolationException ex, WebRequest request) {
        log.error("Error de integridad en DB: {}", ex.getMessage());
        return buildProblemDetail(HttpStatus.CONFLICT, "El registro ya existe o viola una restricción de integridad", "Error de Base de Datos", "/errors/database-error", request);
    }

    // OBLIGATORIO: Acceso Denegado (Security)
    @ExceptionHandler(AccessDeniedException.class)
    public ProblemDetail handleAccessDenied(AccessDeniedException ex, WebRequest request) {
        log.error("Intento de acceso no autorizado a: {}", request.getDescription(false));
        return buildProblemDetail(HttpStatus.FORBIDDEN, "No tienes permisos para esta acción", "Acceso Denegado", "/errors/forbidden", request);
    }
}