/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Address;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author peter
 */
public class AddressFacade {
    
    private static AddressFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private AddressFacade() {}
    
    public static AddressFacade getAddressFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new AddressFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public Address getAddress(Address address) throws WebApplicationException {
        
        return null;
        
        //TODO
    }
    
}
