package com.example.basicPersistance.producer;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.apache.deltaspike.jpa.api.transaction.TransactionScoped;

/**
 *
 * @author Kesha
 */
public class EntityManagerProducer {

    @Inject
    private EntityManagerFactory emf;
    
    @Produces
    @TransactionScoped
    private EntityManager createEntityManager() {
        System.out.println("Create new EntityManager");
        return emf.createEntityManager();
    }

    private void closeEntityManager(@Disposes EntityManager em) {
        if (em.isOpen()) {
            System.out.println("Close EntityManager");
            em.close();
        }
    }


}
