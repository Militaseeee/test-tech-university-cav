package com.practice_cav.tech_university.infrastructure.adapter.out.external.adapter;

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
    public boolean checkDebt(String documentNumber) {
        try {
            DebtRequest request = new DebtRequest(documentNumber);

            // Hacemos la petición POST manual
            Map<String, Object> response = restTemplate.postForObject(
                    financyUrl + "/check-debt",
                    request,
                    Map.class
            );

            return response != null && (boolean) response.get("hasDebt");
        } catch (Exception e) {
            // Si el servicio está caído o hay error, manejamos la lógica (ej. denegar por precaución)
            return false;
        }
    }
}