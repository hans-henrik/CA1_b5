/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.HobbyDTO;
import dtos.PersonDTO;
import entities.Person;
import entities.Hobby;
import java.util.List;
import java.util.Queue;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
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

    public List<PersonDTO> getPersonsByHobby(Hobby hobby) throws WebApplicationException {
        String hobbyName = hobby.getName();
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
    
    public List<HobbyDTO> getAllHobbies() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Hobby> query = em.createQuery("SELECT h FROM Hobby h", Hobby.class);
        List<Hobby> hobby = query.getResultList();
        hobby.forEach(h -> System.out.println(h));
        return HobbyDTO.getDTOs(hobby);
    }

    public long countPeopleByHobby(String hobbyName) throws WebApplicationException {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT COUNT(p) FROM Person p INNER JOIN p.hobbies h WHERE h.name = :hobbyName");
            query.setParameter("hobbyName", hobbyName);
            long count = (long) query.getSingleResult();
            return count;
        } finally {
            em.close();
        }
    }
}