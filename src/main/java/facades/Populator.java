/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.RenameMeDTO;
import entities.Hobby;
import entities.Person;
import entities.Phone;
import entities.RenameMe;
import javax.persistence.EntityManagerFactory;
import utils.EMF_Creator;

/**
 *
 * @author tha
 */
public class Populator {
    public static void populate(){
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        FacadeExample fe = FacadeExample.getFacadeExample(emf);
        fe.create(new RenameMeDTO(new RenameMe("First 1", "Last 1")));
        fe.create(new RenameMeDTO(new RenameMe("First 2", "Last 2")));
        fe.create(new RenameMeDTO(new RenameMe("First 3", "Last 3")));

        PersonFacade pe = PersonFacade.getPersonFacade(emf);
        pe.createPerson(new Person("hupsihejsa@gmail.com", "Huxi", "Bach"));
        pe.createPerson(new Person("hahaha@gmail.com", "Joker", "Mand"));
        pe.createPerson(new Person("ikkePeter@gmail.com", "Hans-Henrik", "Peterlmao"));

        Person p1 = new Person("telefonmand@hotmail.com","Telefonmand","Telefonsen");
        p1.addHobbies(new Hobby("hiking", "wiki.com/hiking", "exercise", "insanity"));
        p1.addPhone(new Phone(20212021, "Nokia", p1));
        pe.createPerson(p1);

    }
    
    public static void main(String[] args) {
        populate();
    }
}