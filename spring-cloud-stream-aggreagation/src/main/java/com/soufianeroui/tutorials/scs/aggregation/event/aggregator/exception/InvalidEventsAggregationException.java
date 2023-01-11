package com.soufianeroui.tutorials.scs.aggregation.event.aggregator.exception;

import com.soufianeroui.tutorials.scs.aggregation.event.aggregator.validator.AggregationValidationResult;

/**
 * thrown when aggregated message are not valid
 *
 * @author Soufiane Roui
 */
public class InvalidEventsAggregationException extends RuntimeException {
    private AggregationValidationResult aggregationValidationResult;
    private transient Object aggregatedEventsMessage;

    public InvalidEventsAggregationException(Object aggregatedEventsMessage, AggregationValidationResult aggregationValidationResult) {
        super("Aggregated messages contains exceptions: " + aggregatedEventsMessage);
        this.aggregatedEventsMessage = aggregatedEventsMessage;
        this.aggregationValidationResult = aggregationValidationResult;
    }
}
