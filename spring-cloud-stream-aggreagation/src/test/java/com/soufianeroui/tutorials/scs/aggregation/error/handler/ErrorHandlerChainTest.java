package com.soufianeroui.tutorials.scs.aggregation.error.handler;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.messaging.support.ErrorMessage;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Unit Tests for {@link ErrorHandlerChain}
 *
 * @author <a href="mailto:soufiane.roui@digimind.com">Soufiane Roui</a>
 */
@ExtendWith(MockitoExtension.class)
class ErrorHandlerChainTest {

	@InjectMocks
	private ErrorHandlerChain handlerChain;

	@Mock
	private ErrorHandler chain;

	@Test
	void handle_givenErrorMessage_shouldExecuteChain() {
		ErrorMessage errorMessage = new ErrorMessage(new Throwable());

		handlerChain.handle(errorMessage);

		verify(chain, times(1)).handle(errorMessage);
	}
}