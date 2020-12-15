
CREATE TABLE IF NOT EXISTS backend.device
(
    id INTEGER GENERATED BY DEFAULT AS IDENTITY
        CONSTRAINT pk_device
            PRIMARY KEY NOT NULL UNIQUE,
    device_id VARCHAR(255) NOT NULL UNIQUE,
    type VARCHAR(255) NOT NULL,
    location VARCHAR(255),
    created_at TIMESTAMP DEFAULT now() NOT NULL,
    updated_at TIMESTAMP DEFAULT NULL
);

ALTER TABLE backend.device OWNER TO postgres;

CREATE INDEX ix_device_device_id
    ON backend.device (device_id);

CREATE TABLE IF NOT EXISTS backend.temp_history
(
    id INTEGER GENERATED BY DEFAULT AS IDENTITY
    CONSTRAINT pk_temp_history
    PRIMARY KEY NOT NULL UNIQUE,
    --Add guid
    temp INTEGER NOT NULL,
    device_id INTEGER
    CONSTRAINT fk_temp_history_device
    REFERENCES backend.device,
    get_at TIMESTAMP DEFAULT now() NOT NULL
    );

ALTER TABLE backend.temp_history OWNER TO postgres;
--Add user table
--Add locations table