package Galamsey_Project;

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
    ArrayList<String> galamseys = new ArrayList<>();

    public void DBConnect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Galamsey_data","root","");
            st = conn.createStatement();
        } catch(Exception e){
            System.out.println("Error: " + e);
        }
    }

    public Observatory(String observatory_name, String country_name, int year_commenced, int area_covered_km){
        name = observatory_name;
        country = country_name;
        startYear = year_commenced;
        this.area_covered_km = area_covered_km;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getArea_covered_km() {
        return area_covered_km;
    }

    public void setArea_covered_km(int area_covered_km) {
        this.area_covered_km = area_covered_km;
    }

    public void addEvent(Galamsey_Project.Galamsey event){
        if (event.getVeg_col_value() > 3)
            System.out.println("Input Error: Invalid color value");
        else {
            try {
                String query = "insert into Galamsey values("
                        + event.getVegetation_color() + ", "
                        + event.getVeg_col_value() + ", "
                        + event.getLongitude() + ", "
                        + event.getLatitude() + ", "
                        + event.getYear() + ", "
                        + getName() + ")";

                rs = st.executeQuery(query);
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }
    }

    public int largestColValue(){
        ArrayList<Integer> colVals = new ArrayList<>();
        try {
            String query = "Select col_value from Galamsey where obs_name = " + getName();
            rs = st.executeQuery(query);
            while (rs.next())
                colVals.add(Integer.parseInt(rs.toString()));

            Collections.sort(colVals);

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return colVals.get(colVals.size()-1);
    }

    public int averageColVal(){
        ArrayList<Integer> colVals = new ArrayList<>();
        int sum = 0;
        try {
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

    public String allGalamseys(int colValue){
        if (colValue > 3)
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
