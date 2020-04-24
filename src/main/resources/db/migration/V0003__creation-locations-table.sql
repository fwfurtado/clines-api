CREATE TABLE locations (
    id BIGSERIAL,
    country CHAR(2),
    state CHAR(2),
    city VARCHAR(100),

    CONSTRAINT pk_locations PRIMARY KEY (id),
    CONSTRAINT unq_locations UNIQUE (country, state, city)
);