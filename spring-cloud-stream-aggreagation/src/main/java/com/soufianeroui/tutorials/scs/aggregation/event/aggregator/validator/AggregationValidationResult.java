package com.soufianeroui.tutorials.scs.aggregation.event.aggregator.validator;


/**
 * Defines validation result of aggregated messages
 *
 * @author Soufiane Roui
 */
public enum AggregationValidationResult {
    VALID,
    CONTAINS_EXCEPTIONS,
    INVALID_SIZE
}
