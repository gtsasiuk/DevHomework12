package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import javax.validation.constraints.Pattern;


@Entity
@Table(name = "planet")
@Data
public class Planet {
    @Id
    @Pattern(regexp = "^[A-Z0-9]+$")
    private String id;

    @Column(nullable = false, length = 500)
    private String name;
}
