package com.soufianeroui.tutorials.scs.aggregation.error.handler;

import com.digimind.services.topreputation.query.error.exception.MissingMessageHeaderException;
import org.springframework.messaging.support.ErrorMessage;

public interface ErrorHandler {
    void handle(ErrorMessage errorMessage) throws MissingMessageHeaderException;

    void setNext(ErrorHandler errorHandler);
}
