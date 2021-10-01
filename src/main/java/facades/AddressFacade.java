/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Address;
import entities.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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
    
    public List<Person> getPersonByAddress( Address address) throws WebApplicationException {
         EntityManager em = getEntityManager();
        try {
        TypedQuery<Person> q1 = em.createQuery("SELECT p FROM Person p WHERE p.address = :address", Person.class);
        q1.setParameter("address", address);
        List<Person> persons = q1.getResultList();
       
            return persons;
        }finally {
        em.close();
        }      
       }
   }

    

