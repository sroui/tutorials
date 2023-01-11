package com.soufianeroui.tutorials.scs.aggregation.error.consumer;

import com.soufianeroui.tutorials.scs.aggregation.error.handler.ErrorHandlerChain;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.messaging.support.ErrorMessage;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Unit Tests for {@link ErrorChannelConsumer}
 */
@ExtendWith(MockitoExtension.class)
class ErrorChannelConsumerTest {
    @InjectMocks
    private ErrorChannelConsumer errorChannelConsumer;
    @Mock
    private ErrorHandlerChain handlerChain;

    @Test
    void accept_givenDatasourceEventMessage_thenInvokeEventHandlerChain() {
        ErrorMessage errorMessage = new ErrorMessage(new Throwable());

        errorChannelConsumer.accept(errorMessage);

        verify(handlerChain, times(1)).handle(errorMessage);
    }
}