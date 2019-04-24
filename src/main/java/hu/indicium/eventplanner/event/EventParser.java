package hu.indicium.eventplanner.event;

import hu.indicium.eventplanner.schedule.Schedule;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Date;

@Component
public class EventParser implements EventParserInterface {

    private final DateParserInterface dateParser;

    public EventParser(DateParserInterface dateParser) {
        this.dateParser = dateParser;
    }

    @Override
    public Event parseEvent(net.fortuna.ical4j.model.Component component, Schedule schedule) throws ParseException {
        String location = component.getProperty("LOCATION").getValue();
        String summary = component.getProperty("SUMMARY").getValue();
        String description = component.getProperty("DESCRIPTION").getValue();
        Date startDate = dateParser.parseDate(component.getProperty("DTSTART").getValue());
        Date endDate = dateParser.parseDate(component.getProperty("DTEND").getValue());
        return new Event(location, summary, description, startDate, endDate, schedule);
    }
}
