package me.github.fwfurtado.clines.features.flights;

import me.github.fwfurtado.clines.domain.Aircraft;
import me.github.fwfurtado.clines.domain.AircraftModel;
import me.github.fwfurtado.clines.domain.Airport;
import me.github.fwfurtado.clines.domain.Country;
import me.github.fwfurtado.clines.domain.Flight;
import me.github.fwfurtado.clines.domain.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static me.github.fwfurtado.clines.utils.MockMvcFactory.configureMvcContextBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.will;

@ExtendWith(MockitoExtension.class)
public class FlightContractTest {

    private static final Long EXISTING_ID = 1L;
    private static final Long NON_EXISTING_ID = 2L;
    private static final String NON_EXISTING_DEPARTURE_CODE = "FRX";
    private static final String NON_EXISTING_ARRIVAL_CODE = "XRF";
    private static final String GRU_CODE = "GRU";
    private static final Airport DEPARTURE_AIRPORT = new Airport(GRU_CODE, new Location(Country.BR, "SP", "Guarulhos"));
    private static final String CGH_CODE = "CGH";
    private static final Airport ARRIVAL_AIRPORT = new Airport(CGH_CODE, new Location(Country.BR, "SP", "São Paulo"));
    private static final AircraftModel BOEING_737_800 = new AircraftModel(1L, "Boeing 737 800");
    private static final String AC123AX = "AC123AX";
    private static final String NON_EXISTING_AIRCRAFT_CODE = "BC123AX";
    private static final Aircraft DEFAULT_AIRCRAFT = new Aircraft(AC123AX, BOEING_737_800);
    private static final Flight FLIGHT = new Flight(EXISTING_ID, LocalDateTime.now(), BigDecimal.valueOf(235.0), DEPARTURE_AIRPORT, ARRIVAL_AIRPORT, DEFAULT_AIRCRAFT);

    @Spy
    private FlightViewMapper viewMapper;

    @Spy
    private FlightFormMapper formMapper;

    @Mock(lenient = true)
    private FlightRepository repository;

    @Mock(lenient = true)
    private ExistingAircraftService aircraftService;

    @Mock(lenient = true)
    private ExistingAirportService airportService;

    @InjectMocks
    private FlightService service;

    @BeforeEach
    void setup() {
        configureMvcContextBy(new FlightController(service));

        given(repository.findById(EXISTING_ID)).willReturn(Optional.of(FLIGHT));
        given(repository.findById(NON_EXISTING_ID)).willReturn(Optional.empty());
        given(repository.findAll()).willReturn(List.of(FLIGHT));

        will(invocation -> {
            var flight = (Flight) invocation.getArgument(0);
            ReflectionTestUtils.setField(flight, "id", NON_EXISTING_ID);
            return null;
        }).given(repository).save(any(Flight.class));

        given(aircraftService.findByCode(AC123AX)).willReturn(Optional.of(DEFAULT_AIRCRAFT));
        given(airportService.findByCode(GRU_CODE)).willReturn(Optional.of(DEPARTURE_AIRPORT));
        given(airportService.findByCode(CGH_CODE)).willReturn(Optional.of(ARRIVAL_AIRPORT));

        given(airportService.findByCode(NON_EXISTING_DEPARTURE_CODE)).willReturn(Optional.empty());
        given(airportService.findByCode(NON_EXISTING_ARRIVAL_CODE)).willReturn(Optional.empty());
        given(aircraftService.findByCode(NON_EXISTING_AIRCRAFT_CODE)).willReturn(Optional.empty());
    }

}
