/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Person;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import junit.framework.TestCase;

/**
 *
 * @author EG
 */
public class PersonFacadeTest extends TestCase {
    
    public PersonFacadeTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getPersonFacade method, of class PersonFacade.
     */
    public void testGetPersonFacade() {
        System.out.println("getPersonFacade");
        EntityManagerFactory _emf = null;
        PersonFacade expResult = null;
        PersonFacade result = PersonFacade.getPersonFacade(_emf);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPersonById method, of class PersonFacade.
     */
    public void testGetPersonById() {
        System.out.println("getPersonById");
        long id = 0L;
        PersonFacade instance = null;
        Person expResult = null;
        Person result = instance.getPersonById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editPerson method, of class PersonFacade.
     */
    public void testEditPerson() {
        System.out.println("editPerson");
        Person person = null;
        PersonFacade instance = null;
        Person expResult = null;
        Person result = instance.editPerson(person);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllPersons method, of class PersonFacade.
     */
    public void testGetAllPersons() {
        System.out.println("getAllPersons");
        PersonFacade instance = null;
        List<Person> expResult = null;
        List<Person> result = instance.getAllPersons();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createPerson method, of class PersonFacade.
     */
    public void testCreatePerson() {
        System.out.println("createPerson");
        Person person = null;
        PersonFacade instance = null;
        Person expResult = null;
        Person result = instance.createPerson(person);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removePerson method, of class PersonFacade.
     */
    public void testRemovePerson() {
        System.out.println("removePerson");
        int id = 0;
        PersonFacade instance = null;
        instance.removePerson(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
