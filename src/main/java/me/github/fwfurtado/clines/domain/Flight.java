package me.github.fwfurtado.clines.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "flights")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDateTime time;

    @NotNull
    private BigDecimal price;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "departure_id")
    private Airport departure;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "arrival_id")
    private Airport arrival;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "aircraft_id")
    private Aircraft aircraft;

    public Flight(LocalDateTime time, BigDecimal price, Airport departure, Airport arrival, Aircraft aircraft) {
        this.time = time;
        this.price = price;
        this.departure = departure;
        this.arrival = arrival;
        this.aircraft = aircraft;
    }
}
