package com.example.basicPersistance.producer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Kesha
 */
public class EntityManagerFactoryProducer {

    @Produces
    @ApplicationScoped
    private EntityManagerFactory createEntityManagerFactory() {
        System.out.println("Create EntityManagerFactory");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        System.out.println("Get EntityManagerFactory");
        return emf;
    }

    private void closeEntityManagerFactory(@Disposes EntityManagerFactory emf) {
        if (emf.isOpen()) {
            System.out.println("Close EntityManagerFactory");
            emf.close();
        }
    }

}
