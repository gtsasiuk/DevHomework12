CREATE TABLE client (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(200) NOT NULL CHECK (LENGTH(name) BETWEEN 3 AND 200)
);

CREATE TABLE planet (
    id VARCHAR(50) PRIMARY KEY,
    name VARCHAR(500) NOT NULL CHECK (LENGTH(name) BETWEEN 1 AND 500)
);

CREATE TABLE ticket (
    id BIGSERIAL PRIMARY KEY,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    client_id INT NOT NULL,
    from_planet_id VARCHAR(50) NOT NULL,
    to_planet_id VARCHAR(50) NOT NULL,
    CONSTRAINT fk_client FOREIGN KEY (client_id) REFERENCES client (id) ON DELETE CASCADE,
    CONSTRAINT fk_from_planet FOREIGN KEY (from_planet_id) REFERENCES planet (id) ON DELETE CASCADE,
    CONSTRAINT fk_to_planet FOREIGN KEY (to_planet_id) REFERENCES planet (id) ON DELETE CASCADE,
    CONSTRAINT chk_different_planets CHECK (from_planet_id <> to_planet_id)
);