package Galamsey_Project;
/**
 * @author Andrew Duncan
 * This class is meant to gather various data from the all galamsey events recorded
 */

// Import the sql and Arraylist packages to use for later use.
import java.sql.*;
import java.util.ArrayList;


public class Monitoring {
    // instance variables for the mysql database connection

    private Connection conn;
    private Statement st;
    private ResultSet rs;


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
        if (colValue > 3 && colValue < 0) // Ensure that the user inputs a valid color value
            return "Input is higher than 3 or lower than 0.";

        try {
            //Generate, execute and return the largest value recorded by a galamsey
            String query = "Select * from Galamsey where col_value > " + colValue; //This query gets the rows with values
            // greater tham the stated color value.
            rs = st.executeQuery(query); //Execute and return the results of the query

            // while loop to go through the result set generated from the query result and add to a list of all recorded
            // galamsey events
            while (rs.next()) //checks for whether there is a next item in the set.
                galamseys.add(rs.toString()); //add each result to the list
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return galamseys.toString();
    }

    /**
     *
     * @param obs_name Observatory name to specify which observatory average value column to update in the database
     * @return Does not return anything
     */
    public void updateAverageColValue(String obs_name){
        ArrayList<Integer> colVals = new ArrayList<>(); //list of all color values from the galamsey class
        int sum = 0; //Accumulator the sum of color values recorded in each galamsey event
        try {
            String query = "Select col_value from Galamsey where obs_name = " + obs_name; //Select all rows from the
            //Galamsey table which were recorded by the stated observatory name.
            rs = st.executeQuery(query); //Execute and return the query results.
            while (rs.next()) //check if there are more items in the result set.
                colVals.add(Integer.parseInt(rs.toString())); //add the results to the arraylist

            for (int value: colVals)
                sum += value; // increment the accumulator by the sum of numbers in the arraylist individually.

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        double avg_val =  sum/colVals.size();  // compute the average of the color values in the observatory

        try {
            // This query updates the respective observatory average color column by the computed average in the DB.
            String query = "update Observatory set averageColValue= " + avg_val + "where obs_name=" + obs_name;
            rs = st.executeQuery(query); // This executes the query.
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }

    /**
     *
     * @return This returns a string of the observatory with the highest average color value
     */
    public String largeAvgColObsVal(){
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
                    "(select max(averageColValue from Observatory))"; //This query selects the observatory with the
            // highest average color value in the DB.
            rs = st.executeQuery(query); // Execute the query

            //Append the various details of the result to the "observatory" string
            observatory += "Observatory name is: " + rs.getString("obs_name")
                    + "\n Located in: " + rs.getString("country")
                    + "\n Area of: " + rs.getString("area_in_sqkm") + " in square kilometres"
                    + "\n Began in: " + rs.getString("startYear")
                    + "\n Average color value of: " + rs.getString("averageColValue");
        }catch(Exception e) {
            System.out.println("Error: " + e);
        }
        return observatory;
    }

}
