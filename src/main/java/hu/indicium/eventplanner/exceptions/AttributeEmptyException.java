package hu.indicium.eventplanner.exceptions;

public class AttributeEmptyException extends RuntimeException {
    public AttributeEmptyException(String attribute) {
        super(String.format("The attribute %s cannot be empty!", attribute));
    }
}
