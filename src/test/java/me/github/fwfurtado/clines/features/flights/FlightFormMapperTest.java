package me.github.fwfurtado.clines.features.flights;

import me.github.fwfurtado.clines.domain.Aircraft;
import me.github.fwfurtado.clines.domain.AircraftModel;
import me.github.fwfurtado.clines.domain.Airport;
import me.github.fwfurtado.clines.domain.Country;
import me.github.fwfurtado.clines.domain.Location;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FlightFormMapperTest {
    private static final AircraftModel BOEING = new AircraftModel(1L, "Boeign");
    private static final Location GUARULHOS = new Location(Country.BR, "SP", "Guarulhos");
    private static final Location CONGONHAS = new Location(Country.BR, "SP", "Vila Congonhas");

    private static final LocalDateTime DEFAULT_TIME = LocalDateTime.now();
    private static final BigDecimal DEFAULT_PRICE = BigDecimal.TEN;
    private static final Aircraft DEFAULT_AIRCRAFT = new Aircraft("AX123CB", BOEING);
    private static final Airport DEFAULT_DEPARTURE = new Airport("GRU", GUARULHOS);
    private static final Airport DEFAULT_ARRIVAL = new Airport("CGH", CONGONHAS);

    private FlightFormMapper mapper = new FlightFormMapper();

    @Test
    void shouldMapAFlightFormToAFlight() {
        var form = new FlightForm();
        form.setTime(DEFAULT_TIME);
        form.setPrice(DEFAULT_PRICE);
        form.setAircraft(DEFAULT_AIRCRAFT);
        form.setDeparture(DEFAULT_DEPARTURE);
        form.setArrival(DEFAULT_ARRIVAL);

        var flight = mapper.map(form);

        assertEquals(DEFAULT_TIME, flight.getTime());
        assertEquals(DEFAULT_PRICE, flight.getPrice());
        assertEquals(DEFAULT_AIRCRAFT, flight.getAircraft());
        assertEquals(DEFAULT_DEPARTURE, flight.getDeparture());
        assertEquals(DEFAULT_ARRIVAL, flight.getArrival());
    }

}
