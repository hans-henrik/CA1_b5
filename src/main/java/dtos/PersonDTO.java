package dtos;

import entities.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDTO {

    private Long id;
    private String email;
    private String firstName;
    private String lastName;

    public PersonDTO(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public PersonDTO(Person p) {
        if (p.getId() != null) this.id = p.getId();
        this.email = p.getEmail();
        this.firstName = p.getFirstName();
        this.lastName = p.getLastName();
    }

    public static List<PersonDTO> getDTOs(List<Person> persons){
        List<PersonDTO> dtos = new ArrayList();
        persons.forEach(person->dtos.add(new PersonDTO(person)));
        return dtos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "id = " + id +
                ", email = '" + email + '\'' +
                ", firstName = '" + firstName + '\'' +
                ", lastName = '" + lastName + '\'' +
                '}';
    }
}
