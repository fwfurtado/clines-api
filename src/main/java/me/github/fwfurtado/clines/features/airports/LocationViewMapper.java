package me.github.fwfurtado.clines.features.airports;

import me.github.fwfurtado.clines.domain.Location;
import me.github.fwfurtado.clines.infra.Mapper;
import org.springframework.stereotype.Component;

@Component
public class LocationViewMapper implements Mapper<Location, LocationView> {
    @Override
    public LocationView map(Location source) {
        var country = source.getCountry();
        return new LocationView(country.getDescription(), source.getState(), source.getCity());
    }
}
