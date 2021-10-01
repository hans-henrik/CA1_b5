/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author peter
 */
@Entity
@NamedQuery(name = "Address.deleteAllRows", query = "DELETE from Address")
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String houseNumber;
    
    @OneToMany(mappedBy = "address")
    private List<Person> persons;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    private CityInfo cityInfo;

    public Address() {
    }

    public Address(String street, String houseNumber, CityInfo cityinfo) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.persons = new ArrayList<>();
        this.cityInfo = cityinfo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public CityInfo getCityinfo() {
        return cityInfo;
    }

    public void setCityinfo(CityInfo cityinfo) {
        this.cityInfo = cityinfo;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CityInfo getCityInfo() {
        return cityInfo;
    }

 public void setCityInfo(CityInfo cityInfo) {
        this.cityInfo = cityInfo;
        if(!cityInfo.getAddresses().contains(this)){
            cityInfo.addAddress(this);
        }
    }

    public void addPerson(Person person) {
        if (person != null){
            this.persons.add(person);
            person.setAddress(this);
        }
    }
    
    public void removePerson(Person person) {
        if (person != null){
            this.persons.remove(person);
            person.setAddress(null);
        }
    }

    
    
}
