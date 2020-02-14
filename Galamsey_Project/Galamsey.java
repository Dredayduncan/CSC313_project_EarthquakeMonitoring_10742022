package Galamsey_Project;

public class Galamsey {
    public static enum Vegetation_color{GREEN, YELLOW, BROWN};
    private Vegetation_color vegetation_color;
    private int veg_col_value;
    double [] position = new double[2]; // array to store the longitude and latitude
    private int occurYear;

    /**
     *
     * @param longitude
     * @param latitude
     * @param vegetation_color
     * @param year
     *
     * This creates an object which stores the location where there may be galamsey, the vegetation colour at that location
     * and the year in which this occurs
     */
    public Galamsey(double longitude, double latitude, Vegetation_color vegetation_color, int year){
        position[0] = longitude;
        position[1] = latitude;
        occurYear = year;
        veg_col_value = setColVal(vegetation_color);
        this.vegetation_color = vegetation_color;
    }

    /**
     *
     * @param vegCol
     * @return
     * Determines the vegetation colour value based on the vegetation colour
     * 1 = green
     * 2 = yellow
     * 3 = brown
     */
    public int setColVal(Vegetation_color vegCol) {
        int veg_col_val = 0;
        if(vegCol == Vegetation_color.GREEN){
            veg_col_val = 1;
        }
        else if(vegCol == Vegetation_color.YELLOW){
            veg_col_val = 2;
        }
        else if(vegCol == Vegetation_color.BROWN){
            veg_col_val = 3;
        }
        return veg_col_val;
    }

    /**
     *
     * @return
     * returns the vegetation color value
     */
    public int getVeg_col_value() {
        return veg_col_value;
    }

    /**
     *
     * @return
     *  returns the year in which galamsey began
     */
    public int getYear() {
        return occurYear;
    }

    /**
     *
     * @param year
     * sets the year in which galamsey began
     */
    public void setYear(int year) {
        occurYear = year;
    }

    /**
     *
     * @return
     * returns the latitude and longitude of the galamsey occurence
     */
    public String getPosition(){
        return position.toString();
    }

    /**
     *
     * @return The longitude value of the Galamsey location
     */
    public double getLongitude(){
        return position[0];
    }

    /**
     *
     * @return The latitude value of the Galamsey location
     */
    public double getLatitude(){
        return position[1];
    }

    /**
     *
     * @param longitude
     * @param latitude
     * sets the latitude and longitude of the galamsey occurence
     */
    public void setPosition(double longitude,double latitude){
    	position[0] = longitude;
    	position[1] = latitude;
    }

    /**
     *
     * @return
     * returns the vegetation colour at the possible galamsey location
     */
    public Vegetation_color getVegetation_color() {
    	return vegetation_color;
    }



}
