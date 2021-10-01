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
    
     public List<Person> getPersonsByZipCode(EntityManager em, int zipCode) throws WebApplicationException {
       TypedQuery<Person> q1 = em.createQuery("SELECT a FROM Address a INNER JOIN a.cityInfo.addresses s WHERE s.styleName = :swimStyle", Adress.class);
         return null;
         //TODO
      }
      public void getPersonsByStyleName (EntityManager em, String swimStyle) {
        TypedQuery<Person> q1 = em.createQuery("SELECT p FROM Person p INNER JOIN p.styles s WHERE s.styleName = :swimStyle", Person.class);
        q1.setParameter("swimStyle",swimStyle);
        List<Person> persons = q1.getResultList();
        for (Person p : persons) {
            String str = p.getName();
            System.out.println(str);
        }
        
    }
     
     public List<CityInfo> getAllCityInfos() {
         
         return null;
         //TODO
     }
    
}
