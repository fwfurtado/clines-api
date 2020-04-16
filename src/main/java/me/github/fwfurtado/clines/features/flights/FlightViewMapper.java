package me.github.fwfurtado.clines.features.flights;

import me.github.fwfurtado.clines.domain.Flight;
import me.github.fwfurtado.clines.infra.Mapper;
import org.springframework.stereotype.Component;

@Component
public class FlightViewMapper implements Mapper<Flight, FlightView> {

    @Override
    public FlightView map(Flight source) {
        var departure = source.getDeparture();
        var arrival = source.getArrival();
        var aircraft = source.getAircraft();

        return new FlightView(source.getId(), source.getTime(), source.getPrice(), departure.getCode(), arrival.getCode(), aircraft.getCode());
    }
}
