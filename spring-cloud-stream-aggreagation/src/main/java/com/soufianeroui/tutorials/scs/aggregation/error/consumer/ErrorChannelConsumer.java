package com.soufianeroui.tutorials.scs.aggregation.error.consumer;

import com.soufianeroui.tutorials.scs.aggregation.error.handler.ErrorHandlerChain;
import lombok.RequiredArgsConstructor;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.support.ErrorMessage;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@RequiredArgsConstructor
public class ErrorChannelConsumer implements Consumer<ErrorMessage> {
    private final ErrorHandlerChain handlerChain;

    @Override
    @ServiceActivator(inputChannel = "errorChannel")
    public void accept(ErrorMessage errorMessage) {
        handlerChain.handle(errorMessage);
    }
}
