package com.salapp.java_ee_kubernetes;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

import javax.enterprise.context.ApplicationScoped;
import java.util.Date;

@Liveness
@ApplicationScoped
public class AppLiveCheck implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse
                .named("java-ee-kubernetes")
                .withData("time", String.valueOf(new Date()))
                .up()
                .build();
    }
}
