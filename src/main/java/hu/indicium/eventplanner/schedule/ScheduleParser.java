package hu.indicium.eventplanner.schedule;

import hu.indicium.eventplanner.event.Event;
import hu.indicium.eventplanner.event.EventParserInterface;
import hu.indicium.eventplanner.schedule.exceptions.EventAlreadyExistsException;
import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.Calendar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;

@Component
public class ScheduleParser implements ScheduleParserInterface {

    private static final Logger logger = LoggerFactory.getLogger(ScheduleParser.class);

    private final EventParserInterface eventParser;

    public ScheduleParser(EventParserInterface eventParser) {
        this.eventParser = eventParser;
    }

    @Override
    public Schedule updateSchedule(Schedule schedule) throws IOException, ParserException {
        CalendarBuilder calendarBuilder = new CalendarBuilder();
        Calendar calendar = calendarBuilder.build(ScheduleRetriever.getSchedule(new URL(schedule.getScheduleUrl())));
        schedule.setName(calendar.getProperty("X-WR-CALNAME").getValue());
        schedule.setDescription(calendar.getProperty("X-WR-CALDESC").getValue());
        for (net.fortuna.ical4j.model.Component component : calendar.getComponents()) {
            try {
                if (!component.getName().equals("VTIMEZONE")) {
                    Event event = eventParser.parseEvent(component, schedule);
                    schedule.addEvent(event);
                }
            } catch (EventAlreadyExistsException e) {
                logger.debug(e.getMessage());
            } catch (ParseException e) {
                logger.error(e.getMessage());
            }
        }
        return schedule;
    }
}
