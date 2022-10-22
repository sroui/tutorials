package com.soufianeroui.tutorials.scs.aggregation.error.handler.impl;

import com.soufianeroui.tutorials.scs.aggregation.error.handler.ErrorHandler;
import org.springframework.messaging.support.ErrorMessage;

public abstract class AbstractErrorHandler implements ErrorHandler {
    protected ErrorHandler next;

    @Override
    public void setNext(ErrorHandler errorHandler) {
        next = errorHandler;
    }

    protected void invokeNext(ErrorMessage errorMessage) {
        if (next != null) {
            next.handle(errorMessage);
        }
    }

    ErrorHandler getNext() {
        return next;
    }
}
