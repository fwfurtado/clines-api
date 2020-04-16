package me.github.fwfurtado.clines.exceptions;

public class AircraftNotFoundException extends IllegalArgumentException {
    public AircraftNotFoundException(String message) {
        super(message);
    }
}
