/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.PersonDTO;
import entities.Person;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.ws.rs.WebApplicationException;

/**
 * @author peter
 */
public class HobbyFacade {

    private static HobbyFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private HobbyFacade() {
    }

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

    public List<PersonDTO> getPersonsByHobby(String hobbyName) throws WebApplicationException {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Person> q1 = em.createQuery("SELECT p FROM Person p INNER JOIN p.hobbies h WHERE h.name = :hobbyName", Person.class);
            q1.setParameter("hobbyName", hobbyName);
            List<Person> persons = q1.getResultList();
            return PersonDTO.getDTOs(persons);
        } finally {
            em.close();
        }

    }
}