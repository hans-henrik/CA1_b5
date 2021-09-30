/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author peter
 */
@Entity
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    
    @ManyToMany(mappedBy = "persons",  cascade = CascadeType.PERSIST)
    private List<Hobby> hobby;
    
    @ManyToOne (cascade = CascadeType.PERSIST)
    private Address address;
    
    @OneToMany
    private List<Phone> phone;

    public Person() {
    }

    public Person(String email, String firstName, String lastName, List<Hobby> hobby, Address address, List<Phone> phone) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hobby = hobby;
        this.address = address;
        this.phone = phone;
    }    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    
    
    
    

   
    
}
