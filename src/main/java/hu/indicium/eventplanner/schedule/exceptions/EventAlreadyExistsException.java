package hu.indicium.eventplanner.schedule.exceptions;

public class EventAlreadyExistsException extends RuntimeException {
    public EventAlreadyExistsException(String name) {
        super(String.format("%s already exists in this schedule", name));
    }
}
