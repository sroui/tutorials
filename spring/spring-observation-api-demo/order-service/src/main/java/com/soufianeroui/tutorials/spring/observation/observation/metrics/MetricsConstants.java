package com.soufianeroui.tutorials.spring.observation.observation.metrics;

public final class MetricsConstants {
    // Metric names
    public static String PRODUCTS_FETCH_METRIC_NAME = "products.fetch";
    public static String PRODUCTS_COUNT_TASK_METRIC_NAME = "products.count.task";

    // Tag names
    public static String GREETING_TAG_NAME = "foo";

    private MetricsConstants() {
        throw new UnsupportedOperationException("You cannot instantiate a constants class");
    }
}
