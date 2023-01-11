package com.soufianeroui.tutorials.scs.aggregation.event.supplier;

import com.soufianeroui.tutorials.scs.aggregation.event.model.Event;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Sinks;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static com.soufianeroui.tutorials.scs.aggregation.event.aggregator.constants.EventsAggregatorConstants.EVENT_GROUP_ID_MESSAGE_HEADER;
import static com.soufianeroui.tutorials.scs.aggregation.event.supplier.EventSupplierConstants.*;


/**
 * Supplies {@link Event}
 *
 * @author Soufiane Roui
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class EventSupplier {

    private final Sinks.Many<Message<Event>> eventsPublisher;

    @Scheduled(fixedRate = EVENTS_SUPPLY_INTERVAL_IN_MILLIS)
    public void supplyEvent() {
        Event event = new Event(DUMMY_TEXT_DATA);

        int randomEventGroupId = ThreadLocalRandom.current().nextInt(MIN_GROUP_ID_INCLUSIVE, MAX_GROUP_ID_EXCLUSIVE);
        MessageHeaders messageHeaders = new MessageHeaders(Map.of(EVENT_GROUP_ID_MESSAGE_HEADER, randomEventGroupId));
        Message<Event> eventMessage = MessageBuilder.createMessage(event, messageHeaders);

        log.debug("Publishing event for aggregation: {}", eventMessage);

        eventsPublisher.tryEmitNext(eventMessage);
    }
}
