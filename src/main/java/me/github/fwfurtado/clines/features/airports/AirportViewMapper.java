package me.github.fwfurtado.clines.features.airports;

import lombok.AllArgsConstructor;
import me.github.fwfurtado.clines.domain.Airport;
import me.github.fwfurtado.clines.infra.Mapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AirportViewMapper implements Mapper<Airport, AirportView> {

    private final LocationViewMapper locationViewMapper;

    @Override
    public AirportView map(Airport source) {
        var locationView = locationViewMapper.map(source.getLocation());

        return new AirportView(source.getCode(), locationView);
    }
}
