/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import dtos.PersonDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author peter
 */
@Entity
@NamedQuery(name = "Person.deleteAllRows", query = "DELETE from Person")
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    
    @ManyToMany(mappedBy = "persons",  cascade = CascadeType.PERSIST)
    private List<Hobby> hobbies;
    
    @ManyToOne (cascade = CascadeType.PERSIST)
    private Address address;
    
    @OneToMany(mappedBy = "person", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Phone> phone;

    public Person() {
    }

    public Person(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hobbies = new ArrayList<>();
        this.phone = new ArrayList<>();
    }    
    
   public Person(PersonDTO pDTO) {
       if (pDTO.getId() != null) this.id = pDTO.getId();
       this.email = pDTO.getEmail();
       this.firstName = pDTO.getFirstName();
       this.lastName = pDTO.getLastName();
   }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    public Address getAddress() {
        return address;
    }
    
    public void setAddress(Address address) {
        this.address = address;
        if(!address.getPersons().contains(this)){
            address.addPerson(this);
        }
    }

    public List<Phone> getPhone() {
        return phone;
    }

    public void setPhone(List<Phone> phone) {
        this.phone = phone;
    }

    
       public void addPhone(Phone phone){
        if (phone != null){
            this.phone.add(phone);
            phone.setPerson(this);
        }
    }
    
    public void removePhone(Phone phone){
        if (phone != null){
            this.phone.remove(phone);
            phone.setPerson(null);   
        }
    }
        
        public void addHobbies(Hobby hobby){
        if (hobby != null){
            this.hobbies.add(hobby);
            hobby.getPersons().add(this);
        }
    }
        
    public void removePhone(Hobby hobby){
        if (hobby != null){
            this.hobbies.remove(hobby);
            hobby.getPersons().remove(this);
        }
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", hobbies=" + hobbies +
                ", address=" + address +
                ", phone=" + phone +
                '}';
    }
}
