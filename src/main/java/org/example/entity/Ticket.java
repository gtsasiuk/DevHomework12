package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "ticket")
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_seq")
    @SequenceGenerator(name = "ticket_seq", sequenceName = "ticket_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "created_at", nullable = false)
    private Timestamp date;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "from_planet_id", nullable = false)
    private Planet departurePlanet;

    @ManyToOne
    @JoinColumn(name = "to_planet_id", nullable = false)
    private Planet arrivalPlanet;
}
