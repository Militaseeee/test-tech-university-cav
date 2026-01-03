package com.practice_cav.tech_university.infrastructure.adapter.out.metric;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthMetricsListener {

    private final Counter authFailuresCounter;

    public AuthMetricsListener(MeterRegistry meterRegistry) {
        // Creamos un contador personalizado en Micrometer
        this.authFailuresCounter = Counter.builder("auth.failures.total")
                .description("Total de intentos de login fallidos por credenciales incorrectas")
                .tag("type", "bad_credentials")
                .register(meterRegistry);
    }

    @EventListener
    public void onAuthenticationFailure(AuthenticationFailureBadCredentialsEvent event) {
        authFailuresCounter.increment();
    }
}