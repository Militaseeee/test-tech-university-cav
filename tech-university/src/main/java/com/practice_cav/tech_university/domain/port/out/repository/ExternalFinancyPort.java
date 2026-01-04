package com.practice_cav.tech_university.domain.port.out.repository;

import com.practice_cav.tech_university.domain.model.FinancyStatus;

// Este es para conectarnos luego con el Mock Service
public interface ExternalFinancyPort {
    FinancyStatus checkDebt(String documentNumber);
}