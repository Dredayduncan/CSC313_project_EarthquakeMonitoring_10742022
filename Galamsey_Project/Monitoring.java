package CSC313_project_EarthquakeMonitoring_10742022.Galamsey_Project;
/**
 * @author Andrew Duncan
 * This class is meant to gather various data from the all galamsey events recorded
 */

// Import the sql and Arraylist packages to use for later use.
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;


public class Monitoring {

    // instance variables for the mysql database connection

    private Connection conn;
    private Statement st;
    private ResultSet rs;

    /**
     * This method is responsible for connecting the class to the mysql database.
     */
    public Monitoring(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //This accesses the driver necessary to access the mysql.

            //conn gets the details necessary for the connection to the mysql database.
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Galamsey_data","root","");

            st = conn.createStatement(); // Enables queries to be executed
        } catch(Exception e){
            System.out.println("Error: " + e);
        }
    }

    /**
     *
     * @return Returns the largest color value recorded in a galamsey event.
     */
    public int largestColValue(){
        int value = 0; //Accumulates or is later assigned the largest color value recorded in a galamsey event.
        try{
            String query = "Select max(col_value) from Galamsey"; //This query gets the max color value in the DB.
            rs = st.executeQuery(query); //Execute and return the results of the query
            value += Integer.parseInt(rs.toString()); //Assign the value returned
        }catch(Exception e) {
            System.out.println("Error: " + e);
        }
        return value;
    }

    /**
     *
     * @param colValue The value used to filter all recorded color values greater than it
     * @return Return a list of galamsey events which recorded color values greater than the value.
     */
    public String allGalamseys(int colValue){
        String all= "";
        if (colValue > 3 && colValue < 0) // Ensure that the user inputs a valid color value
            return "Input is higher than 3 or lower than 0.";

        try {
            //Generate, execute and return the largest value recorded by a galamsey
            String query = "Select * from Galamsey where col_value > " + colValue; //This query gets the rows with values
            // greater than the stated color value.
            rs = st.executeQuery(query); //Execute and return the results of the query

            // while loop to go through the result set generated from the query result and add to a list of all recorded
            // galamsey events
            while (rs.next()) //checks for whether there is a next item in the set.
                all += "Vegetation color: " + rs.getString("veg_color")
                        + "\nColor value: " + rs.getString("col_value")
                        + "\nLongitude: " + rs.getString("longitude")
                        + "\nLatitude: " + rs.getString("latitude")
                        + "\nYear of Occurence: " + rs.getString("year")
                        + "\n Recording Observatory: " + rs.getString("obs_name") + "\n";
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return all;
    }

    /**
     *
     * @param obs_name Observatory name to specify which observatory average value column to update in the database
     */
    public void updateAverageColValue(String obs_name){
        try {
            // This query updates the respective observatory average color column by the computed average in the DB.
            String query = "update Observatory set averageColValue= (select ifnull((Select avg(col_value)" +
                    " as col_value from Galamsey where obs_name = '"+obs_name+"'), 0)) where obs_name='"+obs_name+"'";
            int status = st.executeUpdate(query); // This executes the query.
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }

    /**
     *
     * @return This returns a string of the observatory with the highest average color value
     */
    public String obsWithLargestColVal(){
        ArrayList<String> obsNames= new ArrayList<>(); // An empty list meant to be accumulated by observatory names for
        // a further query.
        try{
            String query = "Select obs_name from Observatory"; //Selects all observatory names in the observatory table
            rs = st.executeQuery(query); //Executes and returns the results of the query
            while (rs.next()) // A check for its there are more values in the result set
                obsNames.add(rs.toString()); //Add all the results to the empty arraylist "obsNames"
        }catch (Exception e) {
            System.out.println("Error: " + e);
        }

        for (String name: obsNames) // loop through the arraylist to get the stored names
            updateAverageColValue(name); //apply the update average column method to each of the observatories in the DB

        String observatory = "";
        try{
            String query = "Select * from Observatory where averageColValue = " +
                    "(select max(averageColValue) from Observatory)"; //This query selects the observatory with the
            // highest average color value in the DB.
            rs = st.executeQuery(query); // Execute the query

            while (rs.next()) {
                //Append the various details of the result to the "observatory" string
                observatory += "Observatory name is: " + rs.getString("obs_name")
                        + "\nLocated in: " + rs.getString("country")
                        + "\nArea of: " + rs.getString("area_in_sqkm") + " in square kilometres"
                        + "\nBegan in: " + rs.getString("startYear")
                        + "\nAverage color value of: " + rs.getString("averageColValue") + "\n";
            }

        }catch(Exception e) {
            System.out.println("Error: " + e);
        }
        return observatory;
    }

    /**
     *
     * @return Returns an arraylist of observatories in the database
     */
    public ArrayList<String[]> getallObs(){
        ArrayList<String[]> observatories = new ArrayList<>();
        try {
            String query = "select * from Observatory "; //Selects all data in the Observatory table

            rs = st.executeQuery(query); //Execute the query.

            //Store the resultant data into an String array which is added to the Arraylist.
            while (rs.next()) {
                String[] recs = {rs.getString("obs_name"), rs.getString("country"),
                        rs.getString("startYear"), rs.getString("area_in_sqkm"),
                        rs.getString("averageColValue")};
                observatories.add(recs); //Add the resultant data
            }
        }catch (Exception e){
            System.out.println("Error: " + e);
        }
        return observatories;
    }

    /**
     *
     * @return Returns an arraylist of galamseys in the database
     */
    public ArrayList<String[]> getallGal(){
        ArrayList<String[]> gals = new ArrayList<>();
        try {
            String query = "Select * from Galamsey"; //Select all Galamseys from the database
            rs = st.executeQuery(query); //Execute the query

            while (rs.next()) {
                // Store the data in the respective columns in a string array
                String[] recs = {rs.getString("veg_color"), rs.getString("col_value"),
                        rs.getString("longitude"), rs.getString("latitude"),
                        rs.getString("year"), rs.getString("obs_name")};
                gals.add(recs); //Add the result to an arraylist.
            }
        }catch (Exception e){
            System.out.println("Error: " + e);
        }
        return gals;
    }

    /**
     *
     * @param name Name of the Galamsey.
     * @param longitude Longitude of the Galamsey.
     * @param latitude Latitude of the Galamsey.
     * This method removes a galamsey that has matching credentials as the parameters from the database.
     */
    public void removeGal(String name, Double longitude, Double latitude){
        try {
            String query = "delete from Galamsey where obs_name = '"+name+"' and longitude = '"+longitude+"' and" +
                    " latitude = '"+latitude+"'"; //delete the galamsey with the respective parameters from the DB
            int status = st.executeUpdate(query); // Execute the query.

        }catch (Exception e){
            System.out.println("Error: " + e);
        }
    }

    /**
     *
     * @return Returns a String of Observatories by name
     */
    public String ObsNames(){
        String names = "";
        ArrayList<String[]> data = getallObs(); //Gets all observatories from the database and stores them in an arraylist.

        /*
        Loop through the arraylist and append the names of each observatory to the names variable.
         */
        for (int i = 0; i < data.size(); i++){
            if (i == data.size()-1)
                names += data.get(i)[0] + ". ";
            else
                names += data.get(i)[0] + ", ";
        }
        return names;
    }

}
