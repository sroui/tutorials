package com.soufianeroui.tutorials.scs.aggregation.error.types;

import com.fasterxml.jackson.core.JsonParseException;
import org.springframework.messaging.converter.MessageConversionException;

public enum ErrorType {
    SCHEDULING_DESERIALIZATION_FAILED,
    UNKNOWN;

    public static ErrorType valueOf(Throwable error) {
        if (error instanceof MessageConversionException
                || error instanceof JsonParseException) {
            return SCHEDULING_DESERIALIZATION_FAILED;
        } else {
            return UNKNOWN;
        }
    }
}
