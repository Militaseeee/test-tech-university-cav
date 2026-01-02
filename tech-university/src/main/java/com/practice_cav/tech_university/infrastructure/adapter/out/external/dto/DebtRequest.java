package com.practice_cav.tech_university.infrastructure.adapter.out.external.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DebtRequest {
    private String documentNumber;
}