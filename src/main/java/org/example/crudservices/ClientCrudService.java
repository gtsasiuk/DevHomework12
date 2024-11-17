package org.example.crudservices;

import org.example.dao.ClientDao;
import org.example.entity.Client;

public class ClientCrudService {
    private ClientDao clientDao = new ClientDao();

    public void save(Client client) {
        clientDao.save(client);
    }

    public Client findClientById(Long id) {
        return clientDao.findById(id);
    }

    public void update(Client client) {
        clientDao.update(client);
    }

    public void delete(Client client) {
        clientDao.delete(client);
    }
}
