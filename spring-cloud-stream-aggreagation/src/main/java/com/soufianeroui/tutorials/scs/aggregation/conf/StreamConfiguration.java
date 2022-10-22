package com.soufianeroui.tutorials.scs.aggregation.conf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import reactor.core.publisher.Sinks;

/**
 * Defines Spring cloud stream configuration
 *
 * @author <a href="mailto:soufiane.roui@digimind.com">Soufiane Roui</a>
 */
@Configuration
@Slf4j
public class StreamConfiguration {

    @Bean
    public Sinks.Many<Message<?>> topReputationPartsPublisher() {
        return Sinks.many().unicast().onBackpressureBuffer();
    }
}
