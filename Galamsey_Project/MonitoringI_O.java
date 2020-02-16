package Galamsey_Project;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Nana Osei Somuah, Andrew Duncan, Caleb Otchi, Stephen Torku
 */
public class MonitoringI_O {
    public static void main(String[] args) {

        ArrayList<String> observatories = new ArrayList<>(); //arraylist to store the various observatories
        // Declaration of input variables
        Scanner input = new Scanner(System.in);
        Scanner reply = new Scanner(System.in);

//        boolean mainLoop = true;

        int valueOption;

        // menu printout on the console
    while(true){
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

        // uses switch to determine what menu action should be carried out based on the user's input
        switch(valueOption) {

        //case 1 takes in the observatory data
            case 1:
                System.out.print("Enter observatory name: ");
                String name = reply.nextLine();
                System.out.print("Enter country name: ");
                String countryName = reply.nextLine();
                System.out.print("Enter year commenced: ");
                int yearCommenced = reply.nextInt();
                System.out.print("Enter area covered in km: ");
                int area = reply.nextInt();
                System.out.println("Observatory added!");
                Galamsey_Project.Observatory obs = new Galamsey_Project.Observatory(name, countryName, yearCommenced, area);
                observatories.add(obs.getName());
                break;

            //Case 2 takes in the details of the galamsey
            case  2:
                //ensures that at least one observatory data has been inputted before galamsey can be added
                if (observatories.isEmpty()) {
                    System.out.println("Error: Cannot add galamsey when no observatory exists.");

                } else {
                    System.out.print("Enter longitude: ");
                    double longitude = reply.nextDouble();
                    System.out.print("Enter latitude: ");
                    double latitude = reply.nextDouble();
                    System.out.print("Enter vegetation colour (GREEN, YELLOW or BROWN): ");
                    String vegetationCol = reply.nextLine();
                    System.out.print("Enter year: ");
                    int year = reply.nextInt();
                    System.out.println("Which observatory collected this information? " + observatories.toString() + "?");
                    String obsName = reply.nextLine();
                    Galamsey_Project.Galamsey gal = new Galamsey_Project.Galamsey(longitude, latitude,
                            Galamsey_Project.Galamsey.Vegetation_color.valueOf(vegetationCol.toUpperCase()), year, obsName);
                }
                break;

                //case 3 provides statistics on galamsey
            case 3:
                    System.out.println("The observatory with the largest average galamsey color value is: ");

                    System.out.println("Statistics on largest 'galamsey' ever is ");
                    break;

            //case 4 allows the user to use the gui
            case 4:

         //case 5 allows the user to exit
            case 5:
                System.out.println("Exiting...");
                System.exit(0);


        //default prints a message when an invalid number is typed
                default:
                    System.out.println("Invalid Option");
                    break;

            }


        }
    }

}
