package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import javax.validation.constraints.Pattern;
import java.util.List;


@Entity
@Table(name = "planet")
@Data
public class Planet {
    @Id
    @Pattern(regexp = "^[A-Z0-9]+$")
    private String id;

    @Column(nullable = false, length = 500)
    private String name;

    @OneToMany(mappedBy = "departurePlanet", fetch = FetchType.LAZY)
    private List<Ticket> departureTickets;

    @OneToMany(mappedBy = "arrivalPlanet", fetch = FetchType.LAZY)
    private List<Ticket> arrivalTickets;

    @Override
    public String toString() {
        return "Planet{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
