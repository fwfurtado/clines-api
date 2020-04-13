package me.github.fwfurtado.clines.features.aircraft;

import me.github.fwfurtado.clines.domain.Aircraft;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface AircraftRepository extends Repository<Aircraft, String> {
    Optional<Aircraft> findByCode(String code);

    List<Aircraft> findAll();

    void save(Aircraft aircraft);
}
