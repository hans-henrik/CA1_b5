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
import javax.persistence.TypedQuery;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author peter
 */
public class PhoneFacade {
    
    private static PhoneFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private PhoneFacade() {}
    
    public static PhoneFacade getPhoneFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new PhoneFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public Person getPersonByPhoneNumber( int phoneNumber) throws WebApplicationException {
          EntityManager em = getEntityManager();
        try {
          TypedQuery<Person> q2 = em.createQuery("SELECT p FROM Person p WHERE p.phone = " + phoneNumber, Person.class);
        List<Person> persons = q2.getResultList();
        for (Person p : persons){
            return p;
        }
        return null;    
    } finally{
        em.close();
    }
  }  
}
