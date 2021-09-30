/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.CityInfo;
import entities.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author peter
 */
public class CityInfoFacade {
    
    private static CityInfoFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private CityInfoFacade() {}
    
    public static CityInfoFacade getCityInfoFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CityInfoFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
     public List<Person> getPersonsByZipCode(int zipCode) throws WebApplicationException {
       
         return null;
         //TODO
      }
     
     public List<CityInfo> getAllCityInfos() {
         
         return null;
         //TODO
     }
    
}
