package com.soufianeroui.tutorials.observation.demo;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.observation.DefaultMeterObservationHandler;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import lombok.extern.slf4j.Slf4j;

/**
 * Main program that demonstrates the building blocks of micrometer observation api
 *
 * @author soufiane roui
 */
@Slf4j
public class ObservationHandlerDemoApplication {
    private static ObservationRegistry observationRegistry;
    private static MeterRegistry meterRegistry;

    public static void main(String[] args) {
        buildRegistryWithPrometheus();

        observeAction();

        log.info("Prometheus metrics:\n{}", ((PrometheusMeterRegistry) meterRegistry).scrape());
    }

    private static void buildRegistryWithPrometheus() {
        observationRegistry = ObservationRegistry.create();

        meterRegistry = new PrometheusMeterRegistry(PrometheusConfig.DEFAULT);
        observationRegistry.observationConfig().observationHandler(new DefaultMeterObservationHandler(meterRegistry));
    }

    private static void observeAction() {
        Observation observation = Observation.createNotStarted("test", observationRegistry);
        observation.observe(() -> log.info("Action performed"));
    }
}
