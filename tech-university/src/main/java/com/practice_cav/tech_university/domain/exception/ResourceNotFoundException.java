package com.practice_cav.tech_university.domain.exception;

// la uso cuando busca un id y no exista
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}