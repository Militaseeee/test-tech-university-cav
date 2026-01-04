package com.practice_cav.tech_university.infrastructure.adapter.out.external.adapter;

import com.practice_cav.tech_university.domain.model.FinancyStatus;
import com.practice_cav.tech_university.domain.port.out.repository.ExternalFinancyPort;
import com.practice_cav.tech_university.infrastructure.adapter.out.external.dto.DebtRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class ExternalFinancyAdapter implements ExternalFinancyPort {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${EXTERNAL_SERVICE_FINANCY_URL}")
    private String financyUrl;


    @Override
    public FinancyStatus checkDebt(String documentNumber) {
        try {
            DebtRequest request = new DebtRequest(documentNumber);

            // Hacemos la petición POST al Mock
            Map<String, Object> response = restTemplate.postForObject(
                    financyUrl + "/check-debt",
                    request,
                    Map.class
            );

            // Extraemos los dos datos que nos envía el Mock
            boolean hasDebt = response != null && (boolean) response.get("hasDebt");
            String externalId = response != null ? (String) response.get("externalCheckId") : "NO-ID";

            // DEVOLVEMOS EL OBJETO COMPLETO (Esto arregla el error de compilación)
            return new FinancyStatus(hasDebt, externalId);

        } catch (Exception e) {
            // Si el servicio falla, devolvemos un estado por defecto
            // (puedes decidir si denegar o permitir la matrícula aquí)
            return new FinancyStatus(false, "SERVICE-ERROR");
        }
    }
}