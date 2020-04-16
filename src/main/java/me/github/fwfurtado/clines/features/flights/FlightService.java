package me.github.fwfurtado.clines.features.flights;

import lombok.AllArgsConstructor;
import me.github.fwfurtado.clines.exceptions.AircraftNotFoundException;
import me.github.fwfurtado.clines.exceptions.AirportNotFoundException;
import me.github.fwfurtado.clines.exceptions.ResourceNotFoundException;
import me.github.fwfurtado.clines.exceptions.ViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class FlightService {


    private final FlightRepository repository;
    private final FlightFormMapper formMapper;
    private final FlightViewMapper viewMapper;
    private final ExistingAircraftService aircraftService;
    private final ExistingAirportService airportService;

    public FlightView showFlightBy(Long id) {
        return repository.findById(id).map(viewMapper::map).orElseThrow(() -> new ResourceNotFoundException("Cannot find flight"));
    }

    public List<FlightView> listAllFlights() {
        return repository.findAll().stream().map(viewMapper::map).collect(toList());
    }

    public Long createNewFlightBy(FlightForm form) {
        assertThatReferencesIsValid(form);

        var flight = formMapper.map(form);

        repository.save(flight);

        return flight.getId();
    }

    private void assertThatReferencesIsValid(FlightForm form) {
        var violations = new ArrayList<Exception>();

        aircraftService
                .findByCode(form.getAircraftId())
                .ifPresentOrElse(form::setAircraft, () -> violations.add(new AircraftNotFoundException("Invalid Aircraft")));

        airportService
                .findByCode(form.getDepartureId())
                .ifPresentOrElse(form::setDeparture, () -> violations.add(new AirportNotFoundException("Invalid Departure")));

        airportService
                .findByCode(form.getArrivalId())
                .ifPresentOrElse(form::setArrival, () -> violations.add(new AirportNotFoundException("Invalid Arrival")));

        if (!violations.isEmpty()) {
            throw new ViolationException(violations);
        }

    }
}
