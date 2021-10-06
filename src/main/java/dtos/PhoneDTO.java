package dtos;

import entities.Phone;

import java.util.ArrayList;
import java.util.List;

public class PhoneDTO {

    private Long id;
    private int number;
    private String description;

    public PhoneDTO(Phone p){
        if(p != null){
            this.id = p.getId();
            this.number = p.getNumber();
            this.description = p.getDescription();
        }
    }

    public PhoneDTO(int number, String description) {
        this.number = number;
        this.description = description;
    }

    public static List<PhoneDTO> getDTOs(List<Phone> phones){
        List<PhoneDTO> phoneDTOS = new ArrayList<PhoneDTO>();
        phones.forEach(phone -> phoneDTOS.add(new PhoneDTO(phone)));
        return phoneDTOS;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "PhoneDTO{" +
                "id=" + id +
                ", number=" + number +
                ", description='" + description + '\'' +
                '}';
    }
}
