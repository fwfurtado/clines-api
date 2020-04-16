package me.github.fwfurtado.clines.exceptions;

public class AirportNotFoundException extends IllegalArgumentException {
    public AirportNotFoundException(String message) {
        super(message);
    }
}
