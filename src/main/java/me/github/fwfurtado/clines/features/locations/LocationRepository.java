package me.github.fwfurtado.clines.features.locations;

import me.github.fwfurtado.clines.domain.Location;
import me.github.fwfurtado.clines.features.airports.ExistingLocationService;
import org.springframework.data.repository.Repository;

public interface LocationRepository extends Repository<Location, Long>, ExistingLocationService {
}
