package com.soufianeroui.tutorials.scs.aggregation.aggregator;

import com.soufianeroui.tutorials.scs.aggregation.aggregator.exception.InvalidEventsAggregationException;
import com.soufianeroui.tutorials.scs.aggregation.aggregator.validator.AggregatedEventsValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import javax.annotation.PostConstruct;
import java.util.function.Function;


/**
 * todo adapt doc
 * Aggregates messages that are published by {@link EventsAggregator#eventsPublisher} and
 * contains the same header 'scheduler_id'.
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class EventsAggregator {
    private final Sinks.Many<Message<?>> eventsPublisher;
    private final Function<Flux<Message<?>>, Flux<Message<?>>> aggregatorFunction;
    private final AggregatedEventsValidator aggregatedEventsValidator;

    @PostConstruct
    public void aggregate() {
        Flux<Message<?>> output = aggregatorFunction.apply(eventsPublisher.asFlux());
        output.subscribe(this::aggregate);
    }

    public void aggregate(Message<?> aggregatedEventsMessage) {
        if (aggregatedEventsValidator.isValid(aggregatedEventsMessage.getPayload())) {
            log.debug("Aggregation succeeded for aggregation id '{}'", aggregatedEventsMessage.getHeaders().get("eventId"));
        }

        String errMessage = "Aggregation failed for events " + aggregatedEventsMessage.getPayload();

        throw new InvalidEventsAggregationException();
    }
}
