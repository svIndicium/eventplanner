package hu.indicium.eventplanner.studytype.exceptions;

import hu.indicium.eventplanner.exceptions.AttributeEmptyException;

public class ShortNameEmptyException extends AttributeEmptyException {
    public ShortNameEmptyException() {
        super("short name");
    }
}
