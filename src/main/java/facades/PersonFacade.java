/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.*;
import entities.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.ws.rs.WebApplicationException;
import utils.EMF_Creator;

/**
 *
 * @author peter
 */
public class PersonFacade {
    

    private static PersonFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private PersonFacade() {}
    
    public static PersonFacade getPersonFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new PersonFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public Person getPersonById ( long id) {
          EntityManager em = getEntityManager();
        try {
        TypedQuery<Person> q1 = em.createQuery("SELECT p FROM Person p WHERE p.p_id = " + id, Person.class);
        List<Person> persons = q1.getResultList();
        for (Person p : persons) {
            return p;
        }
        return null;
    }finally{
            em.close();
        }
    }
    
    public Person editPerson(Person person) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(person);
            em.getTransaction().commit();
            return person;
        } finally {
            em.close();
        }
    }
    
    
    public List<Person> getAllPersons() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p", Person.class);
        List<Person> persons = query.getResultList();
        return persons;
    }
 
     public Person createPerson(Person person) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(person);     
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return person;
    }
    
     //TODO update errorhandling
     
      public void removePerson(int id) throws WebApplicationException{
        EntityManager em = emf.createEntityManager();
        Person person;
        try {
            em.getTransaction().begin();
            person = em.find(Person.class, id);
            if (person == null) {
                throw new WebApplicationException("Id does not exist");
            }
            em.remove(person);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
      
      
      
      
     
}
