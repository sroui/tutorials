package com.soufianeroui.tutorials.scs.aggregation.error.handler.impl;

import com.soufianeroui.tutorials.scs.aggregation.error.handler.ErrorHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.messaging.support.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * Unit Tests for {@link AbstractErrorHandler}
 */
class AbstractErrorHandlerTest {

    private AbstractErrorHandler abstractErrorHandler;

    @BeforeEach
    void setUp() {
        abstractErrorHandler = mock(AbstractErrorHandler.class, CALLS_REAL_METHODS);
    }

    @Test
    void setNext_givenNextHandlerError_shouldSetNextErrorHandler() {
        ErrorHandler errorHandler = mock(ErrorHandler.class);

        abstractErrorHandler.setNext(errorHandler);

        assertThat(abstractErrorHandler.getNext()).isSameAs(errorHandler);
    }

    @Test
    void setNext_givenNextHandlerError_shouldInvokeNextErrorHandler() {
        ErrorMessage errorMessage = new ErrorMessage(new Throwable());
        ErrorHandler errorHandler = mock(ErrorHandler.class);
        abstractErrorHandler.setNext(errorHandler);

        abstractErrorHandler.invokeNext(errorMessage);

        verify(errorHandler, times(1)).handle(errorMessage);
    }
}