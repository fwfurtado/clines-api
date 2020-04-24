package me.github.fwfurtado.clines.features.locations;

import lombok.AllArgsConstructor;
import me.github.fwfurtado.clines.domain.Location;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("locations")
@AllArgsConstructor
public class LocationController {
    private final LocationRepository repository;

    @GetMapping
    List<Location> list() {
        return repository.findAll();
    }
}
