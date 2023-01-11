package com.soufianeroui.tutorials.scs.aggregation.event.aggregator;

import com.soufianeroui.tutorials.scs.aggregation.event.aggregator.exception.InvalidEventsAggregationException;
import com.soufianeroui.tutorials.scs.aggregation.event.aggregator.validator.AggregatedEventsValidator;
import com.soufianeroui.tutorials.scs.aggregation.event.aggregator.validator.AggregationValidationResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import reactor.core.scheduler.Schedulers;

import javax.annotation.PostConstruct;
import java.util.function.Function;


/**
 * Responsible for aggregating messages
 *
 * @author Soufiane Roui
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
        output.subscribeOn(Schedulers.boundedElastic()).subscribe(this::aggregate);
    }

    public void aggregate(Message<?> aggregatedEventsMessage) {
        AggregationValidationResult aggregationValidationResult =
                aggregatedEventsValidator.validate(aggregatedEventsMessage.getPayload());

        if (AggregationValidationResult.VALID.equals(aggregationValidationResult)) {
            log.info("Success aggregation of messages: {}", aggregatedEventsMessage.getPayload());
        } else {
            throw new InvalidEventsAggregationException(aggregatedEventsMessage, aggregationValidationResult);
        }
    }
}
