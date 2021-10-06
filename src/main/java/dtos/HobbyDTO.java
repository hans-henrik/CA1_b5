package dtos;

import entities.Hobby;
import entities.Person;

import java.util.ArrayList;
import java.util.List;

public class HobbyDTO {
    private Long id;
    private String name;

    private String wikiLink;
    private String category;
    private String type;

    private List<PersonDTO> persons;

    public HobbyDTO(String name, String wikiLink, String category, String type, List<Person> persons) {
        this.name = name;
        this.wikiLink = wikiLink;
        this.category = category;
        this.type = type;
        this.persons = PersonDTO.getDTOs(persons);
    }

    public HobbyDTO(Hobby hobby) {
        if(hobby.getId() != null) this.id = hobby.getId();
        this.name = hobby.getName();
        this.wikiLink = hobby.getWikiLink();
        this.category = hobby.getCategory();
        this.type = hobby.getType();
        //this.persons = PersonDTO.getDTOs(hobby.getPersons());
    }

    public static List<HobbyDTO> getDTOs(List<Hobby> hobbies){
        List<HobbyDTO> hdtos = new ArrayList<>();
        hobbies.forEach(h -> hdtos.add(new HobbyDTO(h)));
        return hdtos;
    }

    @Override
    public String toString() {
        return "HobbyDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", wikiLink='" + wikiLink + '\'' +
                ", category='" + category + '\'' +
                ", type='" + type + '\'' +
                ", persons=" + persons +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWikiLink() {
        return wikiLink;
    }

    public void setWikiLink(String wikiLink) {
        this.wikiLink = wikiLink;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<PersonDTO> getPersons() {
        return persons;
    }

    public void setPersons(List<PersonDTO> persons) {
        this.persons = persons;
    }
}
