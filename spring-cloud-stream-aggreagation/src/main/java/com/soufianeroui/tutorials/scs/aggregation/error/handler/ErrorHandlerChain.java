package com.soufianeroui.tutorials.scs.aggregation.error.handler;

import com.soufianeroui.tutorials.scs.aggregation.error.handler.impl.LogErrorHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.messaging.support.ErrorMessage;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ErrorHandlerChain implements ApplicationContextAware {
    private ErrorHandler chain;

    public void handle(ErrorMessage errorMessage) {
        chain.handle(errorMessage);
    }

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        ErrorHandler logErrorHandler = ctx.getBean(LogErrorHandler.class);
        // add handlers to the chain logErrorHandler.setNext(..)

        chain = logErrorHandler;
    }
}
