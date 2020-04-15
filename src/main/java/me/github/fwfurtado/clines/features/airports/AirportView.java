package me.github.fwfurtado.clines.features.airports;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AirportView {
    private String code;
    private LocationView location;
}
