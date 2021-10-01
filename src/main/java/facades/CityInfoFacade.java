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
import javax.persistence.TypedQuery;
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
    
    public List<Person> getPersonsByZipCode( int zipCode) throws WebApplicationException {
          EntityManager em = getEntityManager();
        try {
       TypedQuery<Person> q1 = em.createQuery("SELECT a FROM Address a INNER JOIN a.cityInfo.addresses p WHERE p.persons = : zipCode", Person.class);
           q1.setParameter("persons",zipCode);
         List<Person> persons = q1.getResultList();
         for (Person p : persons){
             String str = p.getFirstName();
           System.out.println(str);
       } 
         return null;
         
      }finally{
            em.close();
        }
        }
    
     
     public List<CityInfo> getAllCityInfos() {
         
         return null;
         //TODO
     }
    
}
