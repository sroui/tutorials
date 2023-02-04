package com.soufianeroui.tutorials.observation.demo;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;

/**
 * Main program that demonstrates different life cylce phases of an {@link Observation}
 *
 * @author soufiane roui
 */
public class ObservationLifecycleDemoApplication {

    public static void main(String[] args) {
        observeUsingVerboseCode();
        observeUsingSimplifiedCode();
    }
    private static void observeUsingSimplifiedCode() {
        ObservationRegistry observationRegistry = ObservationRegistry.create();
        Observation observation = Observation.createNotStarted("sample", observationRegistry);

        observation.observe(() -> System.out.println("Action performed using simplified code"));
    }

    private static void observeUsingVerboseCode() {
        ObservationRegistry observationRegistry = ObservationRegistry.create();
        Observation observation = Observation.createNotStarted("sample", observationRegistry); // stopped

        observation.start(); //started

        try (Observation.Scope scope = observation.openScope()) { // scope opened and closed after action execution
            System.out.println("Action performed using verbose code");
        } catch (Exception e) {
            observation.error(e); //error
        } finally {
            observation.stop(); //stopped
        }
    }
}
