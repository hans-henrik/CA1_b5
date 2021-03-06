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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author peter
 */
@Entity
@NamedQuery(name = "CityInfo.deleteAllRows", query = "DELETE from CityInfo")
public class CityInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=35)
    private String city;

    @Column(length = 4)
    private int zipCode;
    @OneToMany(mappedBy = "cityInfo", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Address> addresses;

    public CityInfo() {
    }

    public CityInfo(int zipCode, String city) {
        this.zipCode = zipCode;
        this.city = city;
        this.addresses = new ArrayList<>();
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addAddress(Address address) {
        if (address != null){
            this.addresses.add(address);
            address.setCityInfo(this);
        }
    }
    
    
    public void removeAddress(Address address) {
        if (address != null){
            this.addresses.remove(address);
            address.setCityInfo(null);
        }
    }

    @Override
    public String toString() {
        return "CityInfo{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", zipCode=" + zipCode +
                ", addresses=" + addresses +
                '}';
    }
}
