package com.soufianeroui.tutorials.scs.aggregation.event.aggregator.constants;


/**
 * Constants related to aggregation configuration
 *
 * @author Soufiane Roui
 */
public final class EventsAggregatorConstants {
    public static final String EVENT_GROUP_ID_MESSAGE_HEADER = "eventGroupId";
    public static final int EVENT_GROUP_SIZE = 5;

    private EventsAggregatorConstants() {
        throw new UnsupportedOperationException("You cannot instantiate a constants class");
    }
}
