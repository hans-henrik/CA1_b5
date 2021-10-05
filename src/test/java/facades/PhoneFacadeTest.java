/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Person;
import entities.Phone;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.validation.constraints.AssertFalse;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator;

/**
 *
 * @author EG
 */
public class PhoneFacadeTest {

    private static EntityManagerFactory emf;
    private static PhoneFacade facade;
    private static PersonFacade facade1;
    private static Person el;

    public PhoneFacadeTest() {
    }

    @BeforeAll
    public static void setUpClass() {
       emf = EMF_Creator.createEntityManagerFactoryForTest();
       facade = PhoneFacade.getPhoneFacade(emf);
       
    }
    
    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }
    
        @BeforeEach
    public void setUp() {
        
        List<Phone> phone = new ArrayList<>();
        el = new Person("Peter@hotmail.com", "Peter", "Andersen");
        phone.add(new Phone(40506070, "Samsung", el));
        el.setPhone(phone);
        
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Phone.deleteAllRows").executeUpdate();
            em.createNamedQuery("Person.deleteAllRows").executeUpdate();
            
            em.persist(el);
            
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
    }
    
    @Test
    public void testGetPersonByPhoneNumber() throws Exception {
        int i = 40506070;
        Person Oliver = new Person("Oliver@hotmail.com", "Oliver", "Andersen");
        
        assertEquals(Oliver.getLastName(), facade.getPersonByPhoneNumber(i).getLastName());
    }
    
}
