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
    
    public Person getPersonByPhoneNumber(int phoneNumber) {
        EntityManager em = emf.createEntityManager();
        Person person = null;
        try{
            TypedQuery<Person> query = em.createQuery("SELECT p from Person p INNER JOIN p.phone ph WHERE ph.Number = :phoneNumber",Person.class);
            query.setParameter("phoneNumber", phoneNumber);
            person = query.getSingleResult();
            
        } finally{
            em.close();
        }
        return person;
    }
    
}
