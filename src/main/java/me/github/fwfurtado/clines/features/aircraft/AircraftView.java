package me.github.fwfurtado.clines.features.aircraft;

import lombok.AllArgsConstructor;
import lombok.Data;
import me.github.fwfurtado.clines.domain.AircraftModel;

@Data
@AllArgsConstructor
public class AircraftView {
    private String code;
    private AircraftModel model;
}
