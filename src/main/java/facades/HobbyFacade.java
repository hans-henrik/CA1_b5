/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author peter
 */
public class HobbyFacade {
    
    private static HobbyFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private HobbyFacade() {}
    
    public static HobbyFacade getHobbyFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new HobbyFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
     public List<Person> getPersonsByHobby(String hobbyName) throws WebApplicationException {
          
         
         return null;
         //TODO
      }
    
}
