package facades;

import dtos.PersonDTO;
import entities.Address;
import entities.CityInfo;
import entities.Hobby;
import entities.Person;
import entities.Phone;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator;
public class PersonFacadeTest extends TestCase{
     private static PersonFacade facade;
   private static Person el;
   private static Hobby h;
   private static Phone p;
   private static Address a;
   private static CityInfo cityinfo;

    private static EntityManagerFactory emf;

  public PersonFacadeTest() {
    }

  @BeforeAll
    public static void setUpClass() {
       emf = EMF_Creator.createEntityManagerFactoryForTest();
       facade = PersonFacade.getPersonFacade(emf);
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
        el = new Person("something","HH","somethingagain");
        CityInfo cityinfo = new CityInfo(2791,"dragør");
        Address a = new Address("hhvej","2",cityinfo);
        el.setAddress(a);
        h = new Hobby("løb","1","2","3");
        p = new Phone(123,"Min iphone",el);
        el.addHobbies(h);
        el.addPhone(p);
       
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Phone.deleteAllRows").executeUpdate();
            em.createNamedQuery("Person.deleteAllRows").executeUpdate();
            em.persist(el);
            em.persist(new Person("Peter@gmail.com","HH","HHH")); 
            em.persist(new Person("Oliver@gmail.com","Oliver","Oliversen")); 
        em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
      @Test
    public void testGetPersonById(){
        Person persons = facade.getPersonById(el.getId());
        assertEquals(el.getFirstName(),persons.getFirstName());
    }
    
    @Test
    public void testGetAllPersons(){
        List<PersonDTO> persons = facade.getAllPersons();
        assertEquals(3,persons.size());
    }
    
    @Test
    public void testCreatePerson()throws Exception{
        facade.createPerson(new Person("1","2","3"));
        assertEquals(4,facade.getPersonCount());
    }
    
    @Test
    public void testRemovePerson(){
        facade.removePerson(el.getId());
        assertEquals(2,facade.getPersonCount());
        
    }
    
    @Test
    public void testEditPerson(){
        el.setEmail("hej");
       facade.editPerson(el);
        assertEquals("hej",el.getEmail());
    }
    
}