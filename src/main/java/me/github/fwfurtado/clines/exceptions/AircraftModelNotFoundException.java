package me.github.fwfurtado.clines.exceptions;

public class AircraftModelNotFoundException extends IllegalArgumentException {
    public AircraftModelNotFoundException(String message) {
        super(message);
    }
}
