package Galamsey_Project;

import java.util.Date;
public class Galamsey {
    public static enum Vegetation_color{GREEN, YELLOW, BROWN};

    private Vegetation_color vegetation_color;
    private int veg_col_value;
    private double[] postion;
    private Date year;

    

    public Galamsey(int veg_col_value, double[] position, Vegetation_color vegetation_color, Date year){
        this.postion = position;
        this.year = year;
        this.veg_col_value = veg_col_value;
        this.vegetation_color = vegetation_color;
    }

    public int getVeg_col_value() {
        return veg_col_value;
    }

    public void setVeg_col_value(int veg_col_value) {
        this.veg_col_value = veg_col_value;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public String getPosition(){
        
    }


    // @Override
    // public String toString(){
    //     String details = "The vegetation colour at this location is:" + this.vegetation_color
    //     + ", which gives a colour value of: " + getVeg_col_value() +
    //      "This "
        

    // }
}
