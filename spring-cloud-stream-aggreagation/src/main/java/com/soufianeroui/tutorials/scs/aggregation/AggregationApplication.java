package com.soufianeroui.tutorials.scs.aggregation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Bootstraps the application.
 *
 * @author Soufiane Roui
 */
@SpringBootApplication
@EnableScheduling
public class AggregationApplication {

    public static void main(String[] args) {
        SpringApplication.run(AggregationApplication.class, args);
    }
}
