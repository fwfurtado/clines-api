package me.github.fwfurtado.clines.features.aircraft;

import me.github.fwfurtado.clines.domain.Aircraft;
import me.github.fwfurtado.clines.infra.Mapper;
import org.springframework.stereotype.Component;

@Component
public class AircraftViewMapper implements Mapper<Aircraft, AircraftView> {

    @Override
    public AircraftView map(Aircraft source) {
        var model = source.getModel();
        return new AircraftView(source.getCode(), model);
    }
}
