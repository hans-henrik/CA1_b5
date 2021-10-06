package dtos;

import entities.Address;
import entities.Hobby;
import entities.Person;
import entities.Phone;

import java.util.ArrayList;
import java.util.List;

public class PersonDTO {

    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private List<HobbyDTO> hobbies;
    private AddressDTO address;
    private List<PhoneDTO> phones;

    public PersonDTO(String email, String firstName, String lastName, List<Hobby> hobbies, Address address, List<Phone> phones) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hobbies = HobbyDTO.getDTOs(hobbies);
        this.address = new AddressDTO(address);
        this.phones = PhoneDTO.getDTOs(phones);
    }

    public PersonDTO(Person p) {
        if (p.getId() != null) this.id = p.getId();
        this.email = p.getEmail();
        this.firstName = p.getFirstName();
        this.lastName = p.getLastName();
        this.hobbies = HobbyDTO.getDTOs(p.getHobbies());
        if(p.getAddress() !=null){
        this.address = new AddressDTO(p.getAddress());
        }
    }

    public Long getId() {
        return id;
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
