package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.PersonDTO;
import entities.Person;
import facades.PersonFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.ws.rs.POST;
import javax.ws.rs.core.Response;

@Path("people")
public class PersonResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private static final PersonFacade FACADE =  PersonFacade.getPersonFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"You made it into /people!\"}";
    }

    @Path("show")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String showPeople() {
        List<PersonDTO> pdto = FACADE.getAllPersons();
        return GSON.toJson(pdto);
    }
    
    @Path("addperson")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public String addPerson(String person){
        PersonDTO pDTO = GSON.fromJson(person,PersonDTO.class);
                pDTO= FACADE.createPersonDTO(pDTO);
        return GSON.toJson(pDTO);
        
    }
    
    @Path("editperson")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public String editPersonDTO(String person){
        PersonDTO pDTO = GSON.fromJson(person,PersonDTO.class);
                pDTO= FACADE.editPersonDTO(pDTO);
        return GSON.toJson(pDTO);   
    }
    
     @Path("removeperson")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public String removePersonDTO(String person){
        PersonDTO pDTO = GSON.fromJson(person,PersonDTO.class);
                pDTO= FACADE.editPersonDTO(pDTO);
        return GSON.toJson(pDTO);   
    }
    
}