package com.practice_cav.tech_university.infrastructure.adapter.in.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule; // Para manejar fechas si es necesario
import com.practice_cav.tech_university.TestcontainersConfiguration;
import com.practice_cav.tech_university.infrastructure.adapter.in.web.dto.request.EnrollmentRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(properties = "EXTERNAL_SERVICE_FINANCY_URL=http://localhost:8081/financy")
@AutoConfigureMockMvc
@Import(TestcontainersConfiguration.class)
class EnrollmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // NO USES @Autowired AQUÍ. Crea la instancia manualmente:
    private final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule()); // Esto ayuda con fechas de Java 8

    @Test
    @WithMockUser(username = "admin@tech.edu", roles = {"ADMIN"})
    void shouldReturnCreated_WhenEnrollingStudent() throws Exception {
        // GIVEN
        EnrollmentRequest request = new EnrollmentRequest();
        request.setStudentId(1L);
        request.setCourseId(1L);

        // WHEN & THEN
        mockMvc.perform(post("/enrollments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated());
    }

//    @Test
//    void shouldReturnForbidden_WhenNoAuth() throws Exception {
//        mockMvc.perform(post("/enrollments")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{}"))
//                .andExpect(status().isForbidden());
//    }

    @Test
    void shouldReturnUnauthorized_WhenNoAuth() throws Exception {
        mockMvc.perform(post("/enrollments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isUnauthorized()); // <-- Cambia Forbidden por Unauthorized
    }

    @Test
    @WithMockUser(username = "estudiante", roles = {"USER"})
    void shouldReturnForbidden_WhenUserIsNotAdmin() throws Exception {
        // Enviamos datos válidos para que lo único que pueda fallar sea la seguridad
        EnrollmentRequest request = new EnrollmentRequest();
        request.setStudentId(1L);
        request.setCourseId(1L);

        mockMvc.perform(post("/enrollments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))) // Enviamos el JSON correcto
                .andExpect(status().isForbidden()); // Ahora sí debería dar 403
    }
}