package com.soufianeroui.tutorials.scs.aggregation.event.model;

import lombok.Data;

import java.util.List;


/**
 * Defines an events group
 *
 * @author Soufiane Roui
 */
@Data
public class EventGroup {
    private List<Event> events;
}
