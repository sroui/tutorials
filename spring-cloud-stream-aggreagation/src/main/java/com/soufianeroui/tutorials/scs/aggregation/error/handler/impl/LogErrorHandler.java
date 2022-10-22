package com.soufianeroui.tutorials.scs.aggregation.error.handler.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.support.ErrorMessage;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LogErrorHandler extends AbstractErrorHandler {

    @Override
    public void handle(ErrorMessage errorMessage) {
        log.error("Error: " + errorMessage);
        invokeNext(errorMessage);
    }
}
