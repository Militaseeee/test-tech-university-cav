// package com.practice_cav.tech_university.infrastructure.adapter.out.external.client;

// import com.practice_cav.tech_university.infrastructure.adapter.out.external.dto.DebtRequest;
// import org.springframework.cloud.openfeign.FeignClient;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import java.util.Map;

// // 'name' identifica al cliente, 'url' apunta al puerto del Mock
// @FeignClient(name = "financy-mock-service", url = "http://localhost:8081/financy")
// public interface FinancyClient {

//     @PostMapping("/check-debt")
//     Map<String, Object> checkDebt(@RequestBody DebtRequest request);
// }