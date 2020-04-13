package me.github.fwfurtado.clines.features.aircraft;

import me.github.fwfurtado.clines.domain.Aircraft;
import me.github.fwfurtado.clines.infra.Mapper;
import org.springframework.stereotype.Component;

import static me.github.fwfurtado.clines.infra.StringNormalizer.normalize;

@Component
public class AircraftFormMapper implements Mapper<AircraftForm, Aircraft> {

    @Override
    public Aircraft map(AircraftForm source) {
        return new Aircraft(normalize(source.getCode()), source.getModel());
    }
}
