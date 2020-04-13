package me.github.fwfurtado.clines.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "aircraft")
public class Aircraft {
    @Id
    @NotNull
    private String code;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "model_id")
    private AircraftModel model;
}
