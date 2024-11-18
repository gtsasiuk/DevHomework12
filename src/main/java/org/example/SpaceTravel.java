package org.example;

import org.example.crudservices.ClientCrudService;
import org.example.crudservices.PlanetCrudService;
import org.example.crudservices.TicketCrudService;
import org.example.entity.Client;
import org.example.entity.Planet;
import org.example.entity.Ticket;

import java.sql.Timestamp;

public class SpaceTravel {
    public static void main(String[] args) {
        ClientCrudService clientService = new ClientCrudService();
        PlanetCrudService planetService = new PlanetCrudService();
        TicketCrudService ticketService = new TicketCrudService();

        System.out.println("=== Testing Client CRUD Operations ===");
        Client client = new Client();
        client.setName("John Doe");
        clientService.save(client);
        System.out.println("Saved client: " + client);

        Client retrievedClient = clientService.findClientById(client.getId());
        System.out.println("Fetched client: " + retrievedClient);

        retrievedClient.setName("Jane Doe");
        clientService.update(retrievedClient);
        System.out.println("Updated client: " + clientService.findClientById(retrievedClient.getId()));

        System.out.println("\n=== Testing Planet CRUD Operations ===");
        Planet planet = new Planet();
        planet.setId("MER");
        planet.setName("Mercury");
        planetService.save(planet);
        System.out.println("Saved planet: " + planet);

        Planet newPlanet = new Planet();
        newPlanet.setId("NEP");
        newPlanet.setName("Neptune");
        planetService.save(newPlanet);
        System.out.println("Saved new planet: " + newPlanet);

        System.out.println("\n=== Testing Ticket CRUD Operations ===");
        Ticket ticket = new Ticket();
        ticket.setDate(new Timestamp(System.currentTimeMillis()));
        ticket.setClient(retrievedClient);
        ticket.setDeparturePlanet(planet);
        ticket.setArrivalPlanet(newPlanet);

        validatePlanets(ticket.getDeparturePlanet(), ticket.getArrivalPlanet());

        ticketService.save(ticket);
        System.out.println("Saved ticket: " + ticket);

        Ticket retrievedTicket = ticketService.findById(ticket.getId());
        System.out.println("Fetched ticket: " + retrievedTicket);

        retrievedTicket.setArrivalPlanet(planetService.getPlanetById("MARS"));
        validatePlanets(retrievedTicket.getDeparturePlanet(), retrievedTicket.getArrivalPlanet());

        ticketService.update(retrievedTicket);
        System.out.println("Updated ticket: " + ticketService.findById(retrievedTicket.getId()));

        ticketService.delete(retrievedTicket);
        System.out.println("Deleted ticket. Attempting to fetch: " + ticketService.findById(retrievedTicket.getId()));

        System.out.println("\n=== Cleaning up ===");
        planetService.delete(newPlanet);
        planetService.delete(planet);
        clientService.delete(retrievedClient);
    }

    private static void validatePlanets(Planet departure, Planet arrival) {
        if (departure.getId().equals(arrival.getId())) {
            throw new IllegalArgumentException("Departure and arrival planets must be different.");
        }
    }
}
