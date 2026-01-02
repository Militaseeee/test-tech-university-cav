package com.practice_cav.tech_university.domain.exception;

public class DebtPendingException extends RuntimeException {
    public DebtPendingException(String message) {
        super(message);
    }
}