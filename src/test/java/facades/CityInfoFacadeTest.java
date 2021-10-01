/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.CityInfo;
import entities.Person;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import junit.framework.TestCase;

/**
 *
 * @author EG
 */
public class CityInfoFacadeTest extends TestCase {
    
    public CityInfoFacadeTest(String testName) {
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
     * Test of getCityInfoFacade method, of class CityInfoFacade.
     */
    public void testGetCityInfoFacade() {
        System.out.println("getCityInfoFacade");
        EntityManagerFactory _emf = null;
        CityInfoFacade expResult = null;
        CityInfoFacade result = CityInfoFacade.getCityInfoFacade(_emf);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPersonsByZipCode method, of class CityInfoFacade.
     */
    public void testGetPersonsByZipCode() {
        System.out.println("getPersonsByZipCode");
        int zipCode = 0;
        CityInfoFacade instance = null;
        List<Person> expResult = null;
        List<Person> result = instance.getPersonsByZipCode(zipCode);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllCityInfos method, of class CityInfoFacade.
     */
    public void testGetAllCityInfos() {
        System.out.println("getAllCityInfos");
        CityInfoFacade instance = null;
        List<CityInfo> expResult = null;
        List<CityInfo> result = instance.getAllCityInfos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
