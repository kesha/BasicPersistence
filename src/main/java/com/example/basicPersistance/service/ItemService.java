package com.example.basicPersistance.service;

import com.example.basicPersistance.model.Item;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import org.apache.deltaspike.jpa.api.transaction.Transactional;

/**
 *
 * @author Kesha
 */
public class ItemService {

    @Inject
    private EntityManager em;
    
    @Transactional
    public Item create(Item item) {
        item = em.merge(item);       
        return item;
    }
    
    
}
