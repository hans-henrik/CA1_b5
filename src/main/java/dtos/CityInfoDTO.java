package dtos;

import entities.CityInfo;

import java.util.ArrayList;
import java.util.List;

public class CityInfoDTO {

    private long id;
    private int zipCode;
    private String name;

    public CityInfoDTO(int zipCode, String name){
        this.zipCode = zipCode;
        this.name = name;
    }

    public CityInfoDTO(CityInfo cityInfo) {
        if(cityInfo.getId() != null) this.id = cityInfo.getId();
        this.zipCode = cityInfo.getZipCode();
        this.name = cityInfo.getCity();
    }

    public static List<CityInfoDTO> getDTOs(List<CityInfo> cities){
        List<CityInfoDTO> cdtos = new ArrayList<>();
        cities.forEach(cityInfo -> cdtos.add(new CityInfoDTO(cityInfo)));
        return cdtos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
