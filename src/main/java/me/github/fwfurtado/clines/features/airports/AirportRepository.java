package me.github.fwfurtado.clines.features.airports;

import me.github.fwfurtado.clines.domain.Airport;
import me.github.fwfurtado.clines.features.flights.ExistingAirportService;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface AirportRepository extends Repository<Airport, String>, ExistingAirportService {
    List<Airport> findAll();

    Optional<Airport> findByCode(String code);

    void save(Airport airport);
}
