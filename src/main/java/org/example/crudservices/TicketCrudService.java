package org.example.crudservices;

import org.example.dao.TicketDao;
import org.example.entity.Ticket;

public class TicketCrudService {
    private TicketDao ticketDao = new TicketDao();

    public void save(Ticket ticket) {
        ticketDao.save(ticket);
    }

    public Ticket findById(Long id) {
        return ticketDao.findById(id);
    }

    public void update(Ticket ticket) {
        ticketDao.update(ticket);
    }

    public void delete(Ticket ticket) {
        ticketDao.delete(ticket);
    }
}
