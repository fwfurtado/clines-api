package me.github.fwfurtado.clines.features.airports;

import me.github.fwfurtado.clines.domain.Airport;
import me.github.fwfurtado.clines.infra.Mapper;
import org.springframework.stereotype.Component;

import static me.github.fwfurtado.clines.infra.StringNormalizer.normalize;

@Component
public class AirportFormMapper implements Mapper<AirportForm, Airport> {
    @Override
    public Airport map(AirportForm source) {
        var code = normalize(source.getCode());
        return new Airport(code, source.getLocation());
    }
}
