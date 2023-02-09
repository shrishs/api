package org.acme.health;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;


@Readiness
public class HealthCheckReadiness implements HealthCheck{

    @Override
    public HealthCheckResponse call() {
        // TODO Auto-generated method stub
        return HealthCheckResponse.named("Readiness").up().build();
    }
    
}
