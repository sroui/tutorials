package com.soufianeroui.tutorials.scs.aggregation.event.aggregator.validator;

import org.springframework.stereotype.Component;

import java.util.List;

import static com.soufianeroui.tutorials.scs.aggregation.event.aggregator.constants.EventsAggregatorConstants.EVENT_GROUP_SIZE;

/**
 * Validates an aggregated events message's payload e.g. validates size of events
 *
 * @author Soufiane Roui
 */
@Component
public class AggregatedEventsValidator {

    public AggregationValidationResult validate(Object payload) {
        List<?> parts = (List<?>) payload;
        boolean containsExceptions = parts.stream().anyMatch(Throwable.class::isInstance);
        boolean invalidSize = parts.size() != EVENT_GROUP_SIZE;

        if (containsExceptions) {
            return AggregationValidationResult.CONTAINS_EXCEPTIONS;
        } else if (invalidSize) {
            return AggregationValidationResult.INVALID_SIZE;
        } else {
            return AggregationValidationResult.VALID;
        }
    }
}
