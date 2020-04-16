CREATE TABLE flights (
    id BIGSERIAL,
    time TIMESTAMP NOT NULL,
    price FLOAT8 NOT NULL,
    aircraft_id VARCHAR(10) NOT NULL,
    departure_id VARCHAR(3) NOT NULL,
    arrival_id VARCHAR(3) NOT NULL,

    CONSTRAINT pk_flights PRIMARY KEY(id),
    CONSTRAINT fk_flights_to_airports FOREIGN KEY (aircraft_id) REFERENCES aircraft(code),
    CONSTRAINT fk_flights_departure_to_airport FOREIGN KEY (departure_id) REFERENCES airports(code),
    CONSTRAINT fk_flights_arrival_to_airport FOREIGN KEY (arrival_id) REFERENCES airports(code)
);