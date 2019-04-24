package hu.indicium.eventplanner.event;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DateParser implements DateParserInterface {
    @Override
    public Date parseDate(String dateTime) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd'T'HHmmss");
        return formatter.parse(dateTime);
    }
}
