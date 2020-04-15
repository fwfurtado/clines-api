package me.github.fwfurtado.clines.features.airports;

import lombok.AllArgsConstructor;
import me.github.fwfurtado.clines.exceptions.LocationNotFoundException;
import me.github.fwfurtado.clines.exceptions.ResourceAlreadyExistsException;
import me.github.fwfurtado.clines.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static me.github.fwfurtado.clines.infra.StringNormalizer.normalize;

@Service
@AllArgsConstructor
public class AirportService {

    private final AirportRepository repository;
    private final AirportViewMapper viewMapper;
    private final AirportFormMapper formMapper;
    private final ExistingLocationService locationService;

    public List<AirportView> listAllAirports() {
        return repository.findAll().stream().map(viewMapper::map).collect(toList());
    }


    public AirportView showAirportBy(String code) {
        return repository.findByCode(code).map(viewMapper::map)
                .orElseThrow(() -> new ResourceNotFoundException("Cannot find airport"));
    }

    public String createNewAirportBy(AirportForm form) {
        var locationId = form.getLocationId();
        var code = normalize(form.getCode());

        repository.findByCode(code).ifPresent(airport -> {
            throw new ResourceAlreadyExistsException("Airport already exists");
        });

        locationService.findById(locationId)
                .ifPresentOrElse(form::setLocation, () -> {
                    throw new LocationNotFoundException("Invalid location");
                });


        var airport = formMapper.map(form);

        repository.save(airport);

        return airport.getCode();
    }
}
