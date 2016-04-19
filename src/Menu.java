import java.util.Scanner;

/**
 * Created by jordan on 4/16/2016.
 */
public class Menu {
    //global first time variable
    private static boolean first = true;
    private static MenuMethods mm = new MenuMethods();

    //this class contains the menu itself as well as the logic to allow a user to select a menu method
    public static void buildMenu(){
        if(first) {
            System.out.println("--------------------------------------------------");
            System.out.println("Hello, welcome to your vehicle collection tracker!");
            System.out.println("--------------------------------------------------");
        }

        System.out.println("\nPlease select an option (number only):");
        System.out.println("(1) Build a garage");
        System.out.println("(2) Buy/Sell a vehicle **Selling method not finished**");
        System.out.println("(3) Get a vehicle out of your garage **Method not written**");
        System.out.println("(4) Put a vehicle back in your garage **Method not written**");
        System.out.println("(5) Show a list of your garages");
        System.out.println("(6) Show a list of your vehicles");
        System.out.println("(7) Paint a car **Method not written**");
        System.out.println("(8) Done for today (this ends the current day and begins all end of day activities) **Method not written**");
        System.out.println("(9) Exit program");
        System.out.print("Selection>");

        selectOption();
    }

    public static void selectOption(){
        first = false;

        //create an input variable
        Scanner userInput = new Scanner(System.in);
        int input = 0;
        String sInput;
        while(input != 9){
            sInput = userInput.nextLine();
            while(!(isInt(sInput))){
                System.out.println("Please only input numeric values.");
                System.out.print("Selection>");
                sInput = userInput.nextLine();
            }
            input = Integer.parseInt(sInput);
            while(input < 1 || input > 9){
                System.out.println("Please select a number between 1 and 9.");
                System.out.print("Selection>");
                sInput = userInput.nextLine();
                while(!(isInt(sInput))){
                    System.out.println("Please only input numeric values.");
                    System.out.print("Selection>");
                    sInput = userInput.nextLine();
                }
                input = Integer.parseInt(sInput);
            }

            switch(input){
                case 1:
                    //build garage
                    mm.buildGarage();
                    buildMenu();
                    break;
                case 2:
                    //buy/sell a vehicle
                    System.out.println("Buy or sell a vehicle? (b/s)");
                    System.out.print("Selection>");
                    sInput = userInput.nextLine();
                    while(!(sInput.equals("b")) && !(sInput.equals("s"))){
                        System.out.println("Please select 'b' or 's' only.");
                        System.out.print("Selection>");
                        sInput = userInput.nextLine();
                    }
                    if(sInput.equals("b")){
                        mm.buyVehicle();
                    } else{
                        mm.sellVehicle();
                    }
                    buildMenu();
                    break;
                case 3:
                    //take a vehicle out on the road (user inputs fuel consumption)
                    mm.removeVehicle();
                    buildMenu();
                    break;
                case 4:
                    //put a vehicle back in its garage
                    mm.returnVehicle();
                    buildMenu();
                    break;
                case 5:
                    //display garages that house vehicles
                    mm.printGarages();
                    buildMenu();
                    break;
                case 6:
                    //display a list of all vehicles in or out of their garages
                    mm.printVehicles();
                    buildMenu();
                    break;
                case 7:
                    //recolor a car
                    mm.paintCar();
                    buildMenu();
                    break;
                case 8:
                    //let a day pass (refuel all vehicles plus any needed maintenance, display total fuel that was
                    //refueled back into the vehicles
                    mm.endDay();
                    buildMenu();
                    break;
                case 9:
                    //exit
                    System.out.println("\nGoodbye");
                    userInput.close(); //clean up after ourselves so we don't leave a resource leak
                    System.exit(0);
                    break;
                default:
                    //this should never happen
                    System.out.println("\nWhoops! Something went wrong with that selection. Please try again.");
                    buildMenu();
                    break;
            }
        }
    }

    public static boolean isInt(String s){
        boolean checkResult = true;
        try{
            Integer.parseInt(s);
        } catch(Exception e){
            checkResult = false;
        }
        return checkResult;
    }
}
