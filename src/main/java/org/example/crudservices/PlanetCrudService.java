package org.example.crudservices;

import org.example.dao.PlanetDao;
import org.example.entity.Planet;

public class PlanetCrudService {
    private PlanetDao planetDao = new PlanetDao();

    public void save(Planet planet) {
        planetDao.save(planet);
    }

    public Planet getPlanetById(String id) {
        return planetDao.findById(id);
    }

    public void update(Planet planet) {
        planetDao.update(planet);
    }

    public void delete(Planet planet) {
        planetDao.delete(planet);
    }
}
