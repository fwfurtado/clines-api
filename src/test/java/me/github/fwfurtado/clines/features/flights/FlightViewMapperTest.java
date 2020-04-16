package me.github.fwfurtado.clines.features.flights;

import me.github.fwfurtado.clines.domain.Aircraft;
import me.github.fwfurtado.clines.domain.AircraftModel;
import me.github.fwfurtado.clines.domain.Airport;
import me.github.fwfurtado.clines.domain.Country;
import me.github.fwfurtado.clines.domain.Flight;
import me.github.fwfurtado.clines.domain.Location;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FlightViewMapperTest {
    private static final AircraftModel BOEING = new AircraftModel(1L, "Boeign");
    private static final Location GUARULHOS = new Location(Country.BR, "SP", "Guarulhos");
    private static final Location CONGONHAS = new Location(Country.BR, "SP", "Vila Congonhas");

    private static final LocalDateTime DEFAULT_TIME = LocalDateTime.now();
    private static final BigDecimal DEFAULT_PRICE = BigDecimal.TEN;
    private static final Aircraft DEFAULT_AIRCRAFT = new Aircraft("AX123CB", BOEING);
    private static final Airport DEFAULT_DEPARTURE = new Airport("GRU", GUARULHOS);
    private static final Airport DEFAULT_ARRIVAL = new Airport("CGH", CONGONHAS);

    private FlightViewMapper mapper = new FlightViewMapper();

    @Test
    void shouldMapAFlightToAFlightView() {
        var flight = new Flight(DEFAULT_TIME, DEFAULT_PRICE, DEFAULT_DEPARTURE, DEFAULT_ARRIVAL, DEFAULT_AIRCRAFT);

        var view = mapper.map(flight);

        assertEquals(DEFAULT_TIME, view.getTime());
        assertEquals(DEFAULT_PRICE, view.getPrice());
        assertEquals(DEFAULT_DEPARTURE.getCode(), view.getDeparture());
        assertEquals(DEFAULT_ARRIVAL.getCode(), view.getArrival());
        assertEquals(DEFAULT_AIRCRAFT.getCode(), view.getAircraft());

    }
}
