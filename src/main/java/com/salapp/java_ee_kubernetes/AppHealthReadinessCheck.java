package com.salapp.java_ee_kubernetes;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

import java.util.Date;

@Readiness
public class AppHealthReadinessCheck implements HealthCheck {

    @Override
    public HealthCheckResponse call() {

        // Get current size of heap in bytes
        long heapSize = Runtime.getRuntime().totalMemory();

        // Get maximum size of heap in bytes. The heap cannot grow beyond this size.// Any attempt will result in an OutOfMemoryException.
        long heapMaxSize = Runtime.getRuntime().maxMemory();

        // Get amount of free memory within the heap in bytes. This size will increase // after garbage collection and decrease as new objects are created.
        long heapFreeSize = Runtime.getRuntime().freeMemory();

        if (heapFreeSize / heapMaxSize * 100 >= 25) {
            return HealthCheckResponse
                    .named("Memory")
                    .withData("memory", String.valueOf(heapFreeSize / heapMaxSize * 100))
                    .status(false)
                    .up()
                    .build();
        } else {
            return HealthCheckResponse
                    .named("AppHealthReadiness")
                    .withData("time", String.valueOf(new Date()))
                    .up()
                    .build();
        }
    }
}
