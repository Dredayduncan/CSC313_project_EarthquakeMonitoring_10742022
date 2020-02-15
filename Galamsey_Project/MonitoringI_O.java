package Galamsey_Project;
import java.util.ArrayList;
import java.util.Scanner;
public class MonitoringI_O {
    public static void main(String[] args) {

        ArrayList<String> observatories = new ArrayList<>();
        // Declaration of input variables
        Scanner input = new Scanner(System.in);
        Scanner reply = new Scanner(System.in);

        int valueOption;

        // menu printout on the console
        System.out.println("|                            SELECTION MENU                            |");
        System.out.println("|  Please select an option:                                            |");
        System.out.println("|  (1) Enter Observatory Data                                          |");
        System.out.println("|  (2) Enter 'Galamsey' Data                                           |");
        System.out.println("|  (3) Provide monitoring statistics on largest average 'galamsey',    |");
        System.out.println("|      largest 'galamsey' ever and all 'galamsey' with colour          |");
        System.out.println("|      value greater than given number                                 |");
        System.out.println("|  (4) Use the app                                                     |");
        System.out.println("|  (5) Exit                                                            |");


        // receives input from the user as a value that selects the option
        System.out.print("|Enter option number: ");
        valueOption = input.nextInt();

        // uses a while loop to determine what menu action should be carried out based on the user's input
        while (valueOption != 0){

            if(valueOption == 1){
                System.out.print("Enter observatory name: ");
                String name = reply.nextLine();
                System.out.print("Enter country name: ");
                String countryName = reply.nextLine();
                System.out.print("Enter year commenced: ");
                int yearCommenced = reply.nextInt();
                System.out.print("Enter area covered in km: ");
                int area = reply.nextInt();
                System.out.println("Observatory added!");
                Galamsey_Project.Observatory obs = new Galamsey_Project.Observatory(name, countryName,yearCommenced,area);
                observatories.add(obs.getName());

            }

<<<<<<< HEAD
            else if(valueOption == 2){
                if (observatories.isEmpty()){
                System.out.println("Error: Cannot add galamsey when no observatory exists.");
                break;
                }
                else {
                    System.out.println(observatories.toString());
                    System.out.print("Enter longitude: ");
                    double longitude = reply.nextDouble();
                    System.out.print("Enter latitude: ");
                    double latitude = reply.nextDouble();
                    System.out.print("Enter vegetation colour: ");
                    String vegetationCol = reply.nextLine();
                    System.out.print("Enter year: ");
                    int year = reply.nextInt();
                    System.out.println("Which observatory collected this information? (" + observatories.toString() + ")?");
                    String obsName = reply.nextLine();
                    Galamsey_Project.Galamsey gal = new Galamsey_Project.Galamsey(longitude, latitude,
                            Galamsey_Project.Galamsey.Vegetation_color.valueOf(vegetationCol.toUpperCase()), year, obsName);
                }
            }

            else if(valueOption == 3){
                System.out.println("The observatory with the largest average galamsey color value is: ");
=======
            if(valueOption == 2){
                System.out.print("Enter longitude: ");
                double longitude = reply.nextDouble();
                System.out.print("Enter latitude: ");
                double latitude = reply.nextDouble();
                System.out.print("Enter vegetation colour (GREEN, YELLOW or BROWN): ");
                String vegetationCol = reply.nextLine();
                System.out.print("Enter year: ");
                int year = reply.nextInt();
                Galamsey_Project.Galamsey event = new Galamsey_Project.Galamsey(longitude, latitude,
                        Galamsey_Project.Galamsey.Vegetation_color.valueOf(vegetationCol.toUpperCase()), year);

            }

            if(valueOption == 3){
                System.out.println("The observatory with the largest average galamsey color value is: " );
>>>>>>> 038b1d13af77856bf7295d9207f23df75b787cf7
                System.out.println("Statistics on largest 'galamsey' ever is ");

            }

            else if(valueOption == 4){

            }



        }



    }
}
