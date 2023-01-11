package com.soufianeroui.tutorials.scs.aggregation.error.consumer;

import com.soufianeroui.tutorials.scs.aggregation.error.handler.ErrorHandlerChain;
import lombok.RequiredArgsConstructor;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.support.ErrorMessage;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

import static org.springframework.messaging.MessageHeaders.ERROR_CHANNEL;


/**
 * Handles all exceptions thrown when consuming messages by spring integration flows (functions included)
 *
 * @author Soufiane Roui
 */
@Component
@RequiredArgsConstructor
public class ErrorChannelConsumer implements Consumer<ErrorMessage> {
    private final ErrorHandlerChain handlerChain;

    @Override
    @ServiceActivator(inputChannel = ERROR_CHANNEL)
    public void accept(ErrorMessage errorMessage) {
        handlerChain.handle(errorMessage);
    }
}
