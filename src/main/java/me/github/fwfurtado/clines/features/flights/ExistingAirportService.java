package me.github.fwfurtado.clines.features.flights;

import me.github.fwfurtado.clines.domain.Airport;

import java.util.Optional;

public interface ExistingAirportService {
    Optional<Airport> findByCode(String code);
}
