/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import javax.persistence.EntityManagerFactory;
import junit.framework.TestCase;

/**
 *
 * @author EG
 */
public class HobbyFacadeTest extends TestCase {
    
    public HobbyFacadeTest(String testName) {
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
     * Test of getHobbyFacade method, of class HobbyFacade.
     */
    public void testGetHobbyFacade() {
        System.out.println("getHobbyFacade");
        EntityManagerFactory _emf = null;
        HobbyFacade expResult = null;
        HobbyFacade result = HobbyFacade.getHobbyFacade(_emf);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPersonsByHobby method, of class HobbyFacade.
     */
    public void testGetPersonsByHobby() {
        System.out.println("getPersonsByHobby");
        String hobbyName = "";
        HobbyFacade instance = null;
        instance.getPersonsByHobby(hobbyName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
