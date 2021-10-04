package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.PersonDTO;
import dtos.PhoneDTO;
import facades.PhoneFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/phones")
public class PhoneResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private static final PhoneFacade FACADE =  PhoneFacade.getPhoneFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String greet() {
        return "Welcome to '/phones/'!";
    }

    @Path("/{number}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String findPersonFromPhonenumber(@PathParam("number") int number){
        PersonDTO dtos = FACADE.getPersonByPhoneNumber(number);
        return GSON.toJson(dtos);
    }
}