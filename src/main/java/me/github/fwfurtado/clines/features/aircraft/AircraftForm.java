package me.github.fwfurtado.clines.features.aircraft;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.github.fwfurtado.clines.domain.AircraftModel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor(access = AccessLevel.PACKAGE)
class AircraftForm {
    @JsonIgnore
    private AircraftModel model;

    @NotBlank
    private String code;

    @NotNull
    @Positive
    private Long modelId;

     AircraftForm(String code, Long modelId) {
        this.code = code;
        this.modelId = modelId;
    }
}
