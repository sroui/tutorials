package com.soufianeroui.tutorials.scs.aggregation.error.handler;

import org.springframework.messaging.support.ErrorMessage;


/**
 * Responsible for handling an error message
 *
 * @author Soufiane Roui
 */
public interface ErrorHandler {
    void handle(ErrorMessage errorMessage);

    void setNext(ErrorHandler errorHandler);
}
