package org.example.hibernateutil;

import org.example.entity.Client;
import org.example.entity.Planet;
import org.flywaydb.core.Flyway;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static HibernateUtil INSTANCE;

    private SessionFactory sessionFactory;

    static {
        Flyway flyway = Flyway.configure()
                        .dataSource("jdbc:postgresql://localhost:5432/dbhibernate", "postgres", "4602")
                        .locations("db/migrations")
                        .load();
        flyway.migrate();
        INSTANCE = new HibernateUtil();
    }

    private HibernateUtil() {
        sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .buildSessionFactory();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void close() {
        sessionFactory.close();
    }

    public static HibernateUtil getInctance() {
        return INSTANCE;
    }
}
