package hu.indicium.eventplanner.schedule;

import net.fortuna.ical4j.data.ParserException;

import java.io.IOException;

public interface ScheduleParserInterface {
    Schedule updateSchedule(Schedule schedule) throws IOException, ParserException;
}
