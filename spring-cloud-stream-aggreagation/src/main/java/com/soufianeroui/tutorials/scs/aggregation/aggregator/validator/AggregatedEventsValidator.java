package com.soufianeroui.tutorials.scs.aggregation.aggregator.validator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

// Todo adapt code and documentation
/**
 * Validates aggregated messages by verifying the following:
 * - existence of message with payload containing {@link ConsumerManualCommitHandler}
 * - existence of all search responses (no exception)
 */
@Component
public class AggregatedEventsValidator {
    /**
     * partsCount = commit handler + response of top search results request + two responses of two top search suggestions requests ("query" request and "query " request ) + responses of top search suggestions requests with each query containing a letter in the ISO basic Latin alphabet
     */
    @Value("#{1 + 1 + 2 + @environment.getProperty('remote.topreputation.google.suggestion.letters').split(',').length}")
    private int partsCount;


    public boolean isValid(Object payload) {
        List<?> parts = (List<?>) payload;
        boolean containsManualKafkaCommitHandler = parts.stream()
                .filter(ConsumerManualCommitHandler.class::isInstance)
                .count() == 1;
        boolean noExceptionIsGenerated = parts.stream().noneMatch(Throwable.class::isInstance);
        boolean hasValidSize = parts.size() == partsCount;
        return containsManualKafkaCommitHandler && noExceptionIsGenerated && hasValidSize;
    }
}
