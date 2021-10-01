/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Address;
import entities.Person;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import junit.framework.TestCase;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import utils.EMF_Creator;

public class AddressFacadeTest extends TestCase{
    
   private static AddressFacade facade;

    private static EntityManagerFactory emf;
    

    public AddressFacadeTest() {
    }

    @BeforeAll
    public static void setUpClass() {
       emf = EMF_Creator.createEntityManagerFactoryForTest();
       facade = AddressFacade.getAddressFacade(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the code below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Person.deleteAllRows").executeUpdate();
            em.persist(new Person("hh@gmail.com","HH","HHH")); 
            em.persist(new Person("Peter@gmail.com","Peter","Petersen")); 
            em.persist(new Person("Oliver@gmail.com","Oliver","Oliversen")); 

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    /**
     * Test of getAddressFacade method, of class AddressFacade.
     */
    public void testGetAddressFacade() {
        System.out.println("getAddressFacade");
        EntityManagerFactory _emf = null;
        AddressFacade expResult = null;
        AddressFacade result = AddressFacade.getAddressFacade(_emf);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPersonByAddress method, of class AddressFacade.
     */
    public void testGetPersonByAddress() {
       //facade.getPersonByAddress(address)
    }
    
}
