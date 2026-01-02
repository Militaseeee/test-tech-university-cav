package com.practice_cav.financy_mock_service.controller;

import com.practice_cav.financy_mock_service.dto.DebtRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/financy")
public class FinancyController {

    @PostMapping("/check-debt")
    public Map<String, Object> checkDebt(@RequestBody DebtRequest request) {
        String doc = request.getDocumentNumber();
        boolean hasDebt = false;

        // Lógica: Si el documento termina en número IMPAR, tiene deuda
        if (doc != null && !doc.isEmpty()) {
            char lastChar = doc.charAt(doc.length() - 1);
            if (Character.isDigit(lastChar)) {
                int lastDigit = Character.getNumericValue(lastChar);
                hasDebt = (lastDigit % 2 != 0);
            }
        }

        return Map.of(
                "documentNumber", doc,
                "hasDebt", hasDebt,
                "message", hasDebt ? "El estudiante tiene deudas pendientes" : "Estudiante sin deudas"
        );
    }
}