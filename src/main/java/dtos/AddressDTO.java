package dtos;

import entities.Address;
import entities.CityInfo;
import entities.Person;

import java.util.List;

public class AddressDTO {
    private Long id;
    private String street;
    private String houseNumber;
    private List<PersonDTO> persons;
    private CityInfoDTO cityInfo;

    public AddressDTO(String street, String houseNumber, List<PersonDTO> persons, CityInfoDTO cityInfo) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.persons = persons;
        this.cityInfo = cityInfo;
    }

    public AddressDTO(Address address) {
        if(address.getId() != null) this.id = address.getId();
        this.street = address.getStreet();
        this.houseNumber = address.getHouseNumber();
        //this.persons = PersonDTO.getDTOs(address.getPersons());
        this.cityInfo = new CityInfoDTO(address.getCityInfo());
    }

    @Override
    public String toString() {
        return "AddressDTO{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", persons=" + persons +
                ", cityInfo=" + cityInfo +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<PersonDTO> getPersons() {
        return persons;
    }

    public void setPersons(List<PersonDTO> persons) {
        this.persons = persons;
    }

    public CityInfoDTO getCityInfo() {
        return cityInfo;
    }

    public void setCityInfo(CityInfoDTO cityInfo) {
        this.cityInfo = cityInfo;
    }
}
