package com.practice_cav.tech_university.domain.exception;

// el estudiante tiene deudas, ya esta matriculado en este curso
public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}