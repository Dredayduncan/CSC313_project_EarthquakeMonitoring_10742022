package Galamsey_Project;

import java.util.Date;
import java.util.List;

public class Observatory {

    private String observatory_name;
    private String country_name;
    private Date year_commenced;
    private int area_covered_km;
    private List events;

    public Observatory(String observatory_name, String country_name, Date year_commenced, int area_covered_km, List events){
        super();
        this.observatory_name = observatory_name;
        this.country_name = country_name;
        this.year_commenced = year_commenced;
        this.area_covered_km = area_covered_km;
        this.events = events;
    }

    public String getObservatory_name() {
        return observatory_name;
    }

    public void setObservatory_name(String observatory_name) {
        this.observatory_name = observatory_name;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public Date getYear_commenced() {
        return year_commenced;
    }

    public void setYear_commenced(Date year_commenced) {
        this.year_commenced = year_commenced;
    }

    public int getArea_covered_km() {
        return area_covered_km;
    }

    public void setArea_covered_km(int area_covered_km) {
        this.area_covered_km = area_covered_km;
    }

    public List getEvents() {
        return events;
    }

    public void setEvents(List events) {
        this.events = events;
    }
}
