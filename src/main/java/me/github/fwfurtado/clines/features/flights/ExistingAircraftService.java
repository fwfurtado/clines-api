package me.github.fwfurtado.clines.features.flights;

import me.github.fwfurtado.clines.domain.Aircraft;

import java.util.Optional;

public interface ExistingAircraftService {
    Optional<Aircraft> findByCode(String code);
}
