package org.example;

import org.example.crudservices.ClientCrudService;
import org.example.crudservices.PlanetCrudService;
import org.example.entity.Client;
import org.example.entity.Planet;

public class SpaceTravel {
    public static void main(String[] args) {
        ClientCrudService clientService = new ClientCrudService();
        PlanetCrudService planetService = new PlanetCrudService();

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

        clientService.delete(retrievedClient);
        System.out.println("Deleted client. Attempting to fetch: " + clientService.findClientById(retrievedClient.getId()));

        System.out.println("\n=== Testing Planet CRUD Operations ===");
        Planet planet = new Planet();
        planet.setId("PLANET01");
        planet.setName("Earth");
        planetService.save(planet);
        System.out.println("Saved planet: " + planet);

        Planet retrievedPlanet = planetService.getPlanetById(planet.getId());
        System.out.println("Fetched planet: " + retrievedPlanet);

        retrievedPlanet.setName("Mars");
        planetService.update(retrievedPlanet);
        System.out.println("Updated planet: " + planetService.getPlanetById(retrievedPlanet.getId()));

        planetService.delete(retrievedPlanet);
        System.out.println("Deleted planet. Attempting to fetch: " + planetService.getPlanetById(retrievedPlanet.getId()));
    }
}
