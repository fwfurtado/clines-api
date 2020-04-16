package me.github.fwfurtado.clines.features.flights;

import me.github.fwfurtado.clines.domain.Flight;
import me.github.fwfurtado.clines.infra.Mapper;
import org.springframework.stereotype.Component;

@Component
public class FlightFormMapper implements Mapper<FlightForm, Flight> {
    @Override
    public Flight map(FlightForm source) {
        return new Flight(source.getTime(), source.getPrice(), source.getDeparture(), source.getArrival(), source.getAircraft());
    }
}
