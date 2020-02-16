/**
 * @author Andrew Duncan
 * This class is meant to convert the details of observatories and Galamsey events into states which can be used
 * and displayed in the TableView object in the GUI
 */
package CSC313_project_EarthquakeMonitoring_10742022.Galamsey_Project;

import Galamsey_Project.Galamsey;
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
    SimpleIntegerProperty occurYear;

    /**
     * This contructor is responsible for receiving and converting the details of the Observatory class
     */
    public TableContent(String observatory_name, String country_name, int year_commenced, double area_covered_km, double average){
        obsName = new SimpleStringProperty(observatory_name);
        country = new SimpleStringProperty(country_name);
        startYear = new SimpleIntegerProperty(year_commenced);
        area = new SimpleDoubleProperty(area_covered_km);
        avg = new SimpleDoubleProperty(average);
    }

    /**
     * This contructor is responsible for receiving and converting the details of the Galamsey class
     */
    public TableContent(double longitude, double latitude, String vegetation_color, int year, String obsName){
    longi = new SimpleDoubleProperty(longitude);
    lat = new SimpleDoubleProperty(latitude);
    veg_color = new SimpleStringProperty(vegetation_color);
    occurYear = new SimpleIntegerProperty(year);
    galObs_name = new SimpleStringProperty(obsName);
    }

    public String getObsName() {
        return obsName.get();
    }

    public double getAvg() {
        return avg.get();
    }

    public SimpleDoubleProperty avgProperty() {
        return avg;
    }

    public SimpleStringProperty obsNameProperty() {
        return obsName;
    }

    public String getCountry() {
        return country.get();
    }

    public SimpleStringProperty countryProperty() {
        return country;
    }

    public double getArea() {
        return area.get();
    }

    public SimpleDoubleProperty areaProperty() {
        return area;
    }

    public int getStartYear() {
        return startYear.get();
    }

    public SimpleIntegerProperty startYearProperty() {
        return startYear;
    }

    public double getLongi() {
        return longi.get();
    }

    public SimpleDoubleProperty longiProperty() {
        return longi;
    }

    public double getLat() {
        return lat.get();
    }

    public SimpleDoubleProperty latProperty() {
        return lat;
    }

    public String getVeg_color() {
        return veg_color.get();
    }

    public SimpleStringProperty veg_colorProperty() {
        return veg_color;
    }

    public String getObs_name() {
        return galObs_name.get();
    }

    public SimpleStringProperty obs_nameProperty() {
        return galObs_name;
    }

    public int getOccurYear() {
        return occurYear.get();
    }

    public SimpleIntegerProperty occurYearProperty() {
        return occurYear;
    }
}
