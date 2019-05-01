package hu.indicium.eventplanner.schedule.exceptions;

public class ScheduleNotFoundException extends RuntimeException {
    public ScheduleNotFoundException(Long scheduleId) {
        super(String.format("Schedule with id %s not found", scheduleId));
    }
}
