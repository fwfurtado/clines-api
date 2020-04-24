package me.github.fwfurtado.clines.features.aircraftmodels;

import me.github.fwfurtado.clines.domain.AircraftModel;
import me.github.fwfurtado.clines.features.aircraft.ExistingAircraftModelService;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface AircraftModelRepository extends Repository<AircraftModel, Long>, ExistingAircraftModelService {
    List<AircraftModel> findAll();
}
