/*
    @author Oliver Juul Reder
    @date 04/10/2021
*/

package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.HobbyDTO;
import dtos.PersonDTO;
import entities.Hobby;
import facades.HobbyFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/hobbies")
public class HobbyResource {
    private static final EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
    private static final HobbyFacade FACADE = HobbyFacade.getHobbyFacade(emf);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String greet(){
        return "\"msg\": Welcome to the Hobby API homepage!";
    }
    
    @Path("show")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String showHobbies() {
        List<HobbyDTO> hdto = FACADE.getAllHobbies();
        return GSON.toJson(hdto);
    }

    @Path("/{hobbyName}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String showPeopleWithHobby(@PathParam("hobbyName") String hobbyName){
        Hobby hobby = new Hobby(hobbyName, "", "", "");
        List<PersonDTO> peoples = FACADE.getPersonsByHobby(hobby);
        return GSON.toJson(peoples);
    }

    @Path("/count/{hobbyName}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String countPeopleWithHobby(@PathParam("hobbyName") String hobbyName){
        return "\"msg\":\"" + FACADE.countPeopleByHobby(hobbyName) + "\"";
    }
}