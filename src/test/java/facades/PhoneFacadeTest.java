/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Person;
import javax.persistence.EntityManagerFactory;
import junit.framework.TestCase;

/**
 *
 * @author EG
 */
public class PhoneFacadeTest extends TestCase {
    
    public PhoneFacadeTest(String testName) {
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
     * Test of getPhoneFacade method, of class PhoneFacade.
     */
    public void testGetPhoneFacade() {
        System.out.println("getPhoneFacade");
        EntityManagerFactory _emf = null;
        PhoneFacade expResult = null;
        PhoneFacade result = PhoneFacade.getPhoneFacade(_emf);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPersonByPhoneNumber method, of class PhoneFacade.
     */
    public void testGetPersonByPhoneNumber() {
        System.out.println("getPersonByPhoneNumber");
        int phoneNumber = 0;
        PhoneFacade instance = null;
        Person expResult = null;
        Person result = instance.getPersonByPhoneNumber(phoneNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
