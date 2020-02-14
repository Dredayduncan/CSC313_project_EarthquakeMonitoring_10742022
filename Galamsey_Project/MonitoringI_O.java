package Galamsey_Project;
import java.util.Scanner;
public class MonitoringI_O {
    public static void main(String[] args) {

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




            }

            if(valueOption == 2){
                System.out.print("Enter longitude: ");
                System.out.print("Enter latitude: ");
                System.out.print();
                System.out.print();

            }

            if(valueOption == 3){

            }

            if(valueOption == 4){

            }



        }



    }
}
