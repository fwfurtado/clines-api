package me.github.fwfurtado.clines.features.airports;

import me.github.fwfurtado.clines.domain.Location;

import java.util.Optional;

public interface ExistingLocationService {
    Optional<Location> findById(Long locationId);
}
