package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "client")
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_seq")
    @SequenceGenerator(name = "client_seq", sequenceName = "client_id_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false, length = 200)
    private String name;

    @OneToMany(mappedBy = "client")
    private List<Ticket> tickets;

    @Override
    public String toString() {
        return "Client{id=" + id + ", name='" + name + "'}";
    }
}
