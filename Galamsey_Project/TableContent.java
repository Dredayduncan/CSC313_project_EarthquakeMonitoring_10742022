/**
 * @author Andrew Duncan
 * This class is meant to convert the details of observatories and Galamsey events into states which can be used
 * and displayed in the TableView object in the GUI
 */
package CSC313_project_EarthquakeMonitoring_10742022.Galamsey_Project;

//import Classes for table view input
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
     *
     * @param observatory_name The name of the observatory
     * @param country_name The country the observatory can be located.
     * @param area_covered_km The area occupied by the observatory.
     * @param year_commenced The year the observatory started operation.
     * @param average The average color value of the observatory
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
     *
     * @param longitude The longitudinal position of the Galamsey.
     * @param latitude The latitudinal position of the Galamsey.
     * @param vegetation_color The vegetation color of the vegetation at the location.
     * @param col_val The color value associated with the vegetation color at the location.
     * @param year The year the event was recorded.
     * @param obsName The name of the observatory that recorded the event.
     */
    public TableContent(double longitude, double latitude, String vegetation_color, int col_val, int year, String obsName){
    longi = new SimpleDoubleProperty(longitude);
    lat = new SimpleDoubleProperty(latitude);
    veg_color = new SimpleStringProperty(vegetation_color);
    occurYear = new SimpleIntegerProperty(year);
    galObs_name = new SimpleStringProperty(obsName);
    colValue = new SimpleIntegerProperty(col_val);
    }

    /**
     *
     * @return Return the String of the Observatory name.
     */
    public String getObsName() {
        return obsName.get();
    }

    /**
     *
     * @return Return the table view property version of the Observatory name.
     */
    public SimpleStringProperty obsNameProperty() {
        return obsName;
    }

    public void setObsName(String obsName) {
        this.obsName.set(obsName);
    }

    /**
     *
     * @return Return the String of the country.
     */
    public String getCountry() {
        return country.get();
    }

    /**
     *
     * @return Return the table view property version of the country.
     */
    public SimpleStringProperty countryProperty() {
        return country;
    }

    public void setCountry(String country) {
        this.country.set(country);
    }

    /**
     *
     * @return Return the double of the area of the observatory.
     */
    public double getArea() {
        return area.get();
    }

    /**
     *
     * @return Return the table view property version of the country.
     */
    public SimpleDoubleProperty areaProperty() {
        return area;
    }

    public void setArea(double area) {
        this.area.set(area);
    }

    /**
     *
     * @return Return the double of the average.
     */
    public double getAvg() {
        return avg.get();
    }

    /**
     *
     * @return Return the table view property version of the average.
     */
    public SimpleDoubleProperty avgProperty() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg.set(avg);
    }

    /**
     *
     * @return Return the int of the year.
     */
    public int getStartYear() {
        return startYear.get();
    }

    /**
     *
     * @return Return the table view property version of the year it started.
     */
    public SimpleIntegerProperty startYearProperty() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear.set(startYear);
    }

    /**
     *
     * @return Return the double of the average.
     */
    public double getLongi() {
        return longi.get();
    }

    /**
     *
     * @return Return the table view property version of the Galamsey longitude.
     */
    public SimpleDoubleProperty longiProperty() {
        return longi;
    }

    public void setLongi(double longi) {
        this.longi.set(longi);
    }

    /**
     *
     * @return Return the double of the Galamsey latitude.
     */
    public double getLat() {
        return lat.get();
    }

    /**
     *
     * @return Return the table view property version of the Galamsey latitude.
     */
    public SimpleDoubleProperty latProperty() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat.set(lat);
    }

    /**
     *
     * @return Return the String of the Galamsey vegetation color.
     */
    public String getVeg_color() {
        return veg_color.get();
    }

    /**
     *
     * @return Return the table view property of the Galamsey vegetation color.
     */
    public SimpleStringProperty veg_colorProperty() {
        return veg_color;
    }

    public void setVeg_color(String veg_color) {
        this.veg_color.set(veg_color);
    }

    /**
     *
     * @return Return the String of the Observatory that recorded the event.
     */
    public String getGalObs_name() {
        return galObs_name.get();
    }

    /**
     *
     * @return Return the table view property version of the Observatory that recorded the event.
     */
    public SimpleStringProperty galObs_nameProperty() {
        return galObs_name;
    }

    public void setGalObs_name(String galObs_name) {
        this.galObs_name.set(galObs_name);
    }

    /**
     *
     * @return Return an integer of the year of occurrence.
     */
    public int getOccurYear() {
        return occurYear.get();
    }

    /**
     *
     * @return Return the table view property version of the year of occurrence.
     */
    public SimpleIntegerProperty occurYearProperty() {
        return occurYear;
    }

    public void setOccurYear(int occurYear) {
        this.occurYear.set(occurYear);
    }

    /**
     *
     * @return Return the int of the color value.
     */
    public int getColValue() {
        return colValue.get();
    }

    /**
     *
     * @return Return the table view property version of the color value.
     */
    public SimpleIntegerProperty colValueProperty() {
        return colValue;
    }

    public void setColValue(int colValue) {
        this.colValue.set(colValue);
    }
}
