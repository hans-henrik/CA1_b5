package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.CityInfoDTO;
import dtos.PersonDTO;
import facades.CityInfoFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/city")
public class CityInfoResource {
    private static final EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
    private static final CityInfoFacade FACADE = CityInfoFacade.getCityInfoFacade(emf);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String greet(){
        String str = "Welcome to the City Info API!";
        return GSON.toJson(str);
    }

    @Path("/{zip}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPeopleByZipcode(@PathParam("zip") String zip) throws WebApplicationException {
        try{
            int intZip = Integer.parseInt(zip);
            List<PersonDTO> pdtos = FACADE.getPersonsByZipCode(intZip);
            return GSON.toJson(pdtos);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            throw new WebApplicationException();
        }
    }

    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllCities(){
        List<CityInfoDTO> cdtos = FACADE.getAllCityInfos();
        return GSON.toJson(cdtos);
    }
}
