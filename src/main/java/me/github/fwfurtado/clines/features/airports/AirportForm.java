package me.github.fwfurtado.clines.features.airports;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.github.fwfurtado.clines.domain.Location;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@NoArgsConstructor
public class AirportForm {
    @JsonIgnore
    @Setter
    private Location location;

    @NotBlank
    private String code;

    @NotNull
    @Positive
    private Long locationId;

    public AirportForm(String code, Long locationId) {
        this.code = code;
        this.locationId = locationId;
    }
}
