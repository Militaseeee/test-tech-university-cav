package com.practice_cav.tech_university.domain.port.out.repository;

// Este es para conectarnos luego con el Mock Service
public interface ExternalFinancyPort {
    boolean checkDebt(String documentNumber);
}