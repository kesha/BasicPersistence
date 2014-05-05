package com.example.basicPersistance;

import com.example.basicPersistance.model.Item;
import com.example.basicPersistance.service.ItemService;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import org.jboss.weld.context.ApplicationContext;
import org.jboss.weld.environment.se.events.ContainerInitialized;

/**
 *
 * @author Kesha
 */
public class App {
    
    @Inject
    private ApplicationContext applicationCtx;

    @Inject
    private ItemService service;

    public App() {
    }

    
    /**
     * @param event
     */
    public void start(@Observes ContainerInitialized event) {
        
       
        Item item1 = new Item();
        System.out.println("Create " + item1 + "...");
        item1 = service.create(item1);
        System.out.println("Created " + item1);

        Item item2 = new Item();
        System.out.println("Create " + item2 + "...");
        item2 = service.create(item2);
        System.out.println("Created " + item2);    
        
        Item item3 = new Item();
        System.out.println("Create " + item3 + "...");
        item3 = service.create(item3);
        System.out.println("Created " + item3);  
        
        applicationCtx.invalidate();

    }

}
