package hu.indicium.eventplanner.studytype.exceptions;

import hu.indicium.eventplanner.exceptions.AttributeEmptyException;

public class NameEmptyException extends AttributeEmptyException {
    public NameEmptyException() {
        super("name");
    }
}
