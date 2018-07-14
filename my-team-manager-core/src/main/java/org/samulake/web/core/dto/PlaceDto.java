package org.samulake.web.core.dto;

public class PlaceDto {
    private Integer id;

    private String streetAndNr;

    private CityDto city;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreetAndNr() {
        return streetAndNr;
    }

    public void setStreetAndNr(String streetAndNr) {
        this.streetAndNr = streetAndNr;
    }

    public CityDto getCity() {
        return city;
    }

    public void setCity(CityDto city) {
        this.city = city;
    }

    public String getPlaceDetails() {
        return getCity().getName() + ", " + getStreetAndNr();
    }

    @Override
    public String toString() {
        return streetAndNr + ", " + city;
    }
}
