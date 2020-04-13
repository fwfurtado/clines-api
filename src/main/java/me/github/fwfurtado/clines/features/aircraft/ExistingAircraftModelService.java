package me.github.fwfurtado.clines.features.aircraft;

import me.github.fwfurtado.clines.domain.AircraftModel;

import java.util.Optional;

public interface ExistingAircraftModelService {
    Optional<AircraftModel> findById(Long id);
}
