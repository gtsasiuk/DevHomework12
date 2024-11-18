package org.example.dao;

import org.example.entity.Ticket;
import org.example.hibernateutil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TicketDao {
    private SessionFactory sessionFactory = HibernateUtil.getInctance().getSessionFactory();

    public void save(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(ticket);
            transaction.commit();
        }
    }

    public Ticket findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Ticket.class, id);
        }
    }

    public void update(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(ticket);
            transaction.commit();
        }
    }

    public void delete(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(ticket);
            transaction.commit();
        }
    }
}
