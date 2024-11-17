
INSERT INTO client (name) VALUES
                              ('Alice Johnson'),
                              ('Bob Smith'),
                              ('Charlie Brown'),
                              ('Diana Prince'),
                              ('Eve White'),
                              ('Frank Black'),
                              ('Grace Hopper'),
                              ('Henry Ford'),
                              ('Ivy Green'),
                              ('Jack Sparrow');


INSERT INTO planet (id, name) VALUES
                                  ('MARS', 'Mars'),
                                  ('VEN', 'Venus'),
                                  ('EARTH', 'Earth'),
                                  ('JUPITER', 'Jupiter'),
                                  ('SATURN', 'Saturn');


INSERT INTO ticket (client_id, from_planet_id, to_planet_id) VALUES
                                                                 (1, 'EARTH', 'MARS'),
                                                                 (2, 'VEN', 'EARTH'),
                                                                 (3, 'MARS', 'VEN'),
                                                                 (4, 'EARTH', 'SATURN'),
                                                                 (5, 'JUPITER', 'MARS'),
                                                                 (6, 'SATURN', 'EARTH'),
                                                                 (7, 'VEN', 'JUPITER'),
                                                                 (8, 'MARS', 'EARTH'),
                                                                 (9, 'EARTH', 'VEN'),
                                                                 (10, 'SATURN', 'MARS');
