package me.github.fwfurtado.clines.features.flights;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class FlightView {
    private Long id;
    private LocalDateTime time;
    private BigDecimal price;
    private String departure;
    private String arrival;
    private String aircraft;
}
