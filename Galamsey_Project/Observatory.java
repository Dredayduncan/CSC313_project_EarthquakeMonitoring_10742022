package Galamsey_Project;
/**
 * @author Nana Osei
 *This class takes in information about the various observatories and stores them
 * in a mysql database
 */

import java.sql.*;
import java.util.*;


public class Observatory {

    // instance variables for the mysql database connection
    private Connection conn;
    private Statement st;
    private ResultSet rs;

    // Instance variables for the Observatory class
    private String name;
    private String country;
    private int startYear;
    private int area_covered_km;
    ArrayList<String> galamseys = new ArrayList<>(); //List of all the Galamseys recorded in the database.

    /**
     * @return Does not return anything
     * This method is responsible for connecting the class to the mysql database.
     */
    public void DBConnect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //This accesses the driver necessary to access the mysql.

            //conn gets the details necessary for the connection to the mysql database.
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Galamsey_data","root","");
            st = conn.createStatement();// Enables queries to be executed
        } catch(Exception e){
            System.out.println("Error: " + e);
        }
    }

    /**
     *
     * @param observatory_name variable that stores the name of the observatory
     * @param country_name variable that stores the name of the country where the observatory is found
     * @param year_commenced variable that stores the year the galamsey observation started
     * @param area_covered_km variable that stores the area of the galamsey location in square kilometers
     */
    public Observatory(String observatory_name, String country_name, int year_commenced, int area_covered_km){
        name = observatory_name;
        country = country_name;
        startYear = year_commenced;
        this.area_covered_km = area_covered_km;

        //the lines of code below is used to insert the user's input into the Observatory table in mysql
        try {
            String query = "insert into Observatory values (" + getName() + ", "
                    + getCountry() + ", "
                    + getArea_covered_km() + ", "
                    + getStartYear() + ", "
                    + "null"
                    + ")";


            rs = st.executeQuery(query);
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }

    /**
     *
     * @return Returns the name of the Observatory
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     *sets the name of the Observatory
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return returns the name of the country where the Observatory is located
     */
    public String getCountry() {
        return country;
    }

    /**
     *
     * @param country
     * sets the name of the country where the observatory is located
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     *
     * @return returns the year that the galamsey observation started
     */
    public int getStartYear() {
        return startYear;
    }

    /**
     *
     * @param startYear
     * sets the year that the galamsey observation started
     */
    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    /**
     *
     * @return returns the area covered by the galamsey in square kilometres
     */
    public int getArea_covered_km() {
        return area_covered_km;
    }

    /**
     *
     * @param area_covered_km
     * sets the area covered by the galamsey in square kilometres
     */
    public void setArea_covered_km(int area_covered_km) {
        this.area_covered_km = area_covered_km;
    }


    /**
     *
     * @return this method returns the largest galamsey color value ever recorded by an observatory
     */
    public int largestColValue(){
        ArrayList<Integer> colVals = new ArrayList<>(); //an arraylist to store the various color values
        try {
            String query = "Select col_value from Galamsey where obs_name = " + getName();
            rs = st.executeQuery(query);
            while (rs.next())
                colVals.add(Integer.parseInt(rs.toString()));

            Collections.sort(colVals); //sorts the values in ascending order

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return colVals.get(colVals.size()-1); //returns the value at the last index which will be the highest value
    }

    /**
     *
     * @return returns the average color value recorded by an observatory
     */
    public int averageColVal(){
        ArrayList<Integer> colVals = new ArrayList<>(); //an arraylist to store the various color values
        int sum = 0; //accumulates the sum of all the color values in the list
        try {
            //looks through the database for all the color values recorded to be stored in the list
            String query = "Select col_value from Galamsey where obs_name = " + getName();
            rs = st.executeQuery(query);
            while (rs.next())
                colVals.add(Integer.parseInt(rs.toString()));

            for (int value: colVals)
                sum += value;

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return sum/colVals.size();
    }

    /**
     *
     * @param colValue
     * @return returns a toString all the galamsey recorded by an observatory with a color value greater than a given number
     */
    public String allGalamseys(int colValue){
        if (colValue > 3) //checks if colour value inputted is greater than the highest possible color value
            return "Input is higher than 3.";

        try {
            String query = "Select * from Galamsey where col_value > " + colValue + " and obs_name = " + getName();
            rs = st.executeQuery(query);

            while (rs.next())
                galamseys.add(rs.toString());
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return galamseys.toString();
    }




}
