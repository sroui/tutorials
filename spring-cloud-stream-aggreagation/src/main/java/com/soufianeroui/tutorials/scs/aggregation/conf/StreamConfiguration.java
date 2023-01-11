package com.soufianeroui.tutorials.scs.aggregation.conf;

import com.soufianeroui.tutorials.scs.aggregation.event.model.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.scheduling.annotation.EnableAsync;
import reactor.core.publisher.Sinks;

import java.util.function.Supplier;

/**
 * Defines Spring cloud stream configuration
 *
 * @author Soufiane Roui
 */
@Configuration
@EnableAsync
@Slf4j
public class StreamConfiguration {

    /**
     * Publisher of events
     *
     * @return publisher
     */
    @Bean
    public Sinks.Many<Message<Event>> eventsPublisher() {
        return Sinks.many().unicast().onBackpressureBuffer();
    }

    /**
     * Added because application do not start without adding a function
     *
     * @return supplier
     */
    @Bean
    public Supplier<Object> fooFunction() {
        return () -> null;
    }
}
