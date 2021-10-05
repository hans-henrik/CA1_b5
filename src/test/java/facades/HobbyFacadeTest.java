
package facades;

import dtos.PersonDTO;
import entities.Address;
import entities.CityInfo;
import entities.Hobby;
import entities.Person;
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
public class HobbyFacadeTest extends TestCase{
      private static HobbyFacade facade;
   private static Person el;
   private static Hobby h;

    private static EntityManagerFactory emf;

  public HobbyFacadeTest() {
    }
  @BeforeAll
    public static void setUpClass() {
       emf = EMF_Creator.createEntityManagerFactoryForTest();
       facade = HobbyFacade.getHobbyFacade(emf);
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
        el.addHobbies(h);
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Hobby.deleteAllRows").executeUpdate();
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
    //fejl
    @Test
    public void testGetPersonByHobby(){
        List<PersonDTO> persons = facade.getPersonsByHobby(el.getHobbies().get(0));
        assertEquals(1,persons.size());
    }
}
    
