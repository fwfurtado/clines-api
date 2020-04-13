package me.github.fwfurtado.clines.exceptions;

public class ResourceAlreadyExistsException extends IllegalArgumentException {
    public ResourceAlreadyExistsException(String message) {
        super(message);
    }
}
