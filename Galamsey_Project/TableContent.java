/**
 * @author Andrew Duncan
 * This class is meant to convert the details of observatories and Galamsey events into states which can be used
 * and displayed in the TableView object in the GUI
 */
package CSC313_project_EarthquakeMonitoring_10742022.Galamsey_Project;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class TableContent {
    //Instance variables for the Observatory class
    SimpleStringProperty obsName, country;
    SimpleDoubleProperty area, avg;
    SimpleIntegerProperty startYear;

    //Instance variables for the Galamsey class
    SimpleDoubleProperty longi, lat;
    SimpleStringProperty veg_color, galObs_name;
    SimpleIntegerProperty occurYear, colValue;

    /**
     * This contructor is responsible for receiving and converting the details of the Observatory class
     */
    public TableContent(String observatory_name, String country_name, double area_covered_km, int year_commenced, double average){
        obsName = new SimpleStringProperty(observatory_name);
        country = new SimpleStringProperty(country_name);
        startYear = new SimpleIntegerProperty(year_commenced);
        area = new SimpleDoubleProperty(area_covered_km);
        avg = new SimpleDoubleProperty(average);
    }

    /**
     * This contructor is responsible for receiving and converting the details of the Galamsey class
     */
    public TableContent(double longitude, double latitude, String vegetation_color, int col_val, int year, String obsName){
    longi = new SimpleDoubleProperty(longitude);
    lat = new SimpleDoubleProperty(latitude);
    veg_color = new SimpleStringProperty(vegetation_color);
    occurYear = new SimpleIntegerProperty(year);
    galObs_name = new SimpleStringProperty(obsName);
    colValue = new SimpleIntegerProperty(col_val);
    }

    public String getObsName() {
        return obsName.get();
    }

    public SimpleStringProperty obsNameProperty() {
        return obsName;
    }

    public void setObsName(String obsName) {
        this.obsName.set(obsName);
    }

    public String getCountry() {
        return country.get();
    }

    public SimpleStringProperty countryProperty() {
        return country;
    }

    public void setCountry(String country) {
        this.country.set(country);
    }

    public double getArea() {
        return area.get();
    }

    public SimpleDoubleProperty areaProperty() {
        return area;
    }

    public void setArea(double area) {
        this.area.set(area);
    }

    public double getAvg() {
        return avg.get();
    }

    public SimpleDoubleProperty avgProperty() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg.set(avg);
    }

    public int getStartYear() {
        return startYear.get();
    }

    public SimpleIntegerProperty startYearProperty() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear.set(startYear);
    }

    public double getLongi() {
        return longi.get();
    }

    public SimpleDoubleProperty longiProperty() {
        return longi;
    }

    public void setLongi(double longi) {
        this.longi.set(longi);
    }

    public double getLat() {
        return lat.get();
    }

    public SimpleDoubleProperty latProperty() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat.set(lat);
    }

    public String getVeg_color() {
        return veg_color.get();
    }

    public SimpleStringProperty veg_colorProperty() {
        return veg_color;
    }

    public void setVeg_color(String veg_color) {
        this.veg_color.set(veg_color);
    }

    public String getGalObs_name() {
        return galObs_name.get();
    }

    public SimpleStringProperty galObs_nameProperty() {
        return galObs_name;
    }

    public void setGalObs_name(String galObs_name) {
        this.galObs_name.set(galObs_name);
    }

    public int getOccurYear() {
        return occurYear.get();
    }

    public SimpleIntegerProperty occurYearProperty() {
        return occurYear;
    }

    public void setOccurYear(int occurYear) {
        this.occurYear.set(occurYear);
    }

    public int getColValue() {
        return colValue.get();
    }

    public SimpleIntegerProperty colValueProperty() {
        return colValue;
    }

    public void setColValue(int colValue) {
        this.colValue.set(colValue);
    }
}
