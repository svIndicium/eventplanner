package hu.indicium.eventplanner.event;

import hu.indicium.eventplanner.schedule.Schedule;
import net.fortuna.ical4j.model.Component;

import java.text.ParseException;

public interface EventParserInterface {
    Event parseEvent(Component component, Schedule schedule) throws ParseException;
}
