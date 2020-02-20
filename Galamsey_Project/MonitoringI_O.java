/**
 * @author Nana Osei Somuah, Andrew Duncan, Caleb Otchi, Stephen Torku
 */
package CSC313_project_EarthquakeMonitoring_10742022.Galamsey_Project;

import java.util.Scanner;

/**
 * This is the main class that should be run to test and the entire program
 */
public class MonitoringI_O {

    public static void main(String[] args) {
        Monitoring data = new Monitoring();

        // Declaration of input variables for the menu and information respectively.
        Scanner input = new Scanner(System.in);
        Scanner reply = new Scanner(System.in);


        // menu printout on the console
    while(true){
        System.out.println("|                            SELECTION MENU                            |");
        System.out.println("|  Please select an option:                                            |");
        System.out.println("|  (1) Enter Observatory Data                                          |");
        System.out.println("|  (2) Enter 'Galamsey' Data                                           |");
        System.out.println("|  (3) Provide monitoring statistics on largest average 'galamsey',    |");
        System.out.println("|      largest 'galamsey' ever and all 'galamsey' with colour          |");
        System.out.println("|      value greater than given number                                 |");
        System.out.println("|  (4) Exit                                                            |");


        // receives input from the user as a value that selects the option
        System.out.print("|Enter option number: ");
        int valueOption = Integer.parseInt(input.nextLine());

        // uses switch to determine what menu action should be carried out based on the user's input
        switch(valueOption) {

            //case 1 takes in the observatory data
            case 1:
                System.out.print("Enter observatory name: ");
                String name = reply.nextLine();
                System.out.print("Enter country name: ");
                String countryName = reply.nextLine();
                System.out.print("Enter year commenced: ");
                int yearCommenced = Integer.parseInt(reply.nextLine());
                System.out.print("Enter area covered in km: ");
                double area = Double.parseDouble(reply.nextLine());
                Observatory obs = new Observatory(name, countryName, yearCommenced, area);
                System.out.println("Observatory added!");
                break;

            //Case 2 takes in the details of the galamsey
            case 2:
                //ensures that at least one observatory data has been inputted before galamsey can be added
                if (data.getallObs().isEmpty()) {
                    System.out.println("\n\nError: Cannot add galamsey when no observatory exists.\n\n");
                    break;

                } else {
                    System.out.print("Enter longitude: ");
                    double longitude = Double.parseDouble(reply.nextLine());
                    System.out.print("Enter latitude: ");
                    double latitude = Double.parseDouble(reply.nextLine());
                    System.out.print("Enter vegetation colour (GREEN, YELLOW or BROWN): ");
                    String vegetationCol = reply.nextLine();
                    System.out.print("Enter year: ");
                    int year = Integer.parseInt(reply.nextLine());
                    System.out.println("Which observatory collected this information?( " + data.ObsNames() + ")?");
                    String obsName = reply.nextLine();
                    Galamsey event = new Galamsey(longitude, latitude,
                            Galamsey.Vegetation_color.valueOf(vegetationCol.toUpperCase()), year, obsName);
                    System.out.println("Galamsey has been added.");
                    break;
                }

            //case 3 provides statistics on galamsey
            case 3:
                System.out.println("The observatory with the largest average galamsey color value is: ");
                System.out.println(data.obsWithLargestColVal());
                System.out.println("The following are the galamseys with a colour value greater than the input given.");
                System.out.print("What colour value will that be? (1, 2, or 3): ");
                int answer = Integer.parseInt(reply.nextLine());
                System.out.println(data.allGalamseys(answer));
                break;

            //case 4 allows the user to exit
            case 4:
                System.out.println("Exiting...");
                System.exit(0);
                break;


            //default prints a message when an invalid number is typed
            default:
                System.out.println("Invalid Option");
                break;

            }


        }
    }


}

