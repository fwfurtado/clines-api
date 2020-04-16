package me.github.fwfurtado.clines.features.flights;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import me.github.fwfurtado.clines.domain.Aircraft;
import me.github.fwfurtado.clines.domain.Airport;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class FlightForm {
    @JsonIgnore
    private Aircraft aircraft;

    @JsonIgnore
    private Airport departure;

    @JsonIgnore
    private Airport arrival;

    @FutureOrPresent
    @NotNull
    private LocalDateTime time;

    @Positive
    @NotNull
    private BigDecimal price;

    @NotBlank
    private String aircraftId;
    @NotBlank
    private String departureId;
    @NotBlank
    private String arrivalId;


}
