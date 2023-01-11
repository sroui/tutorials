package com.soufianeroui.tutorials.scs.aggregation.event.supplier;


/**
 * Defines constants related to {@link EventSupplier}
 *
 * @author Soufiane Roui
 */
public final class EventSupplierConstants {
    public static final int EVENTS_SUPPLY_INTERVAL_IN_MILLIS = 1000;

    public static final String DUMMY_TEXT_DATA = "Dummy text data";

    public static final int MIN_GROUP_ID_INCLUSIVE = 0;
    public static final int MAX_GROUP_ID_EXCLUSIVE = 5;

    private EventSupplierConstants() {
        throw new UnsupportedOperationException("You cannot instantiate a constants class");
    }
}
