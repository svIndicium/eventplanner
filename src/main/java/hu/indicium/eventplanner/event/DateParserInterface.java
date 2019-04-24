package hu.indicium.eventplanner.event;

import java.text.ParseException;
import java.util.Date;

public interface DateParserInterface {
    Date parseDate(String dateTime) throws ParseException;
}
