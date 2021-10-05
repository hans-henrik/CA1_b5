/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.CityInfoDTO;
import dtos.PersonDTO;
import entities.CityInfo;
import entities.Person;
import utils.EMF_Creator;

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
    
    public List<PersonDTO> getPersonsByZipCode( int zipCode) throws WebApplicationException {
          EntityManager em = getEntityManager();
        try {
       TypedQuery<Person> q1 = em.createQuery("SELECT p FROM Person p INNER JOIN p.address.cityInfo c WHERE c.zipCode = :zipCode", Person.class);
           q1.setParameter("zipCode",zipCode);
         List<Person> persons = q1.getResultList();
         
         return PersonDTO.getDTOs(persons);
         
      }finally{
            em.close();
        }
      }
     
     public List<CityInfoDTO> getAllCityInfos() {
         EntityManager em = getEntityManager();
         try {
             TypedQuery<CityInfo> query = em.createQuery("SELECT c FROM CityInfo c", CityInfo.class);
             List<CityInfo> cities = query.getResultList();
             return CityInfoDTO.getDTOs(cities);
         } finally {
             em.close();
         }
     }

     public static void addCity(CityInfo cityInfo){
        EntityManager em = EMF_Creator.createEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        em.persist(cityInfo);
        em.close();
     }
    
}
