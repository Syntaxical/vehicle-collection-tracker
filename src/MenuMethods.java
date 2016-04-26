import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jordan on 4/16/2016.
 */
public class MenuMethods {
    //this class contains all the methods needed to interface with our garages/vehicles via the ui menu
    //it also contains the lists of different object we need to be able to interact with
    private static List<Garage> garages = new LinkedList<>();
    private static UserInput ui = new UserInput();

    //menu option 1 allows the user to build any type of garage
    public void buildGarage(){
        System.out.println("\nSelect the type of garage you would like to build (number only):");
        System.out.println("(1) Car Garage");
        System.out.println("(2) Dock");
        System.out.println("(3) Hangar");
        System.out.print("Selection>");

        //create an input variable
        Scanner userInput = new Scanner(System.in);
        int iInput;
        String sInput;
        sInput = userInput.nextLine();
        iInput = ui.testIntWithinRange(sInput, 1, 3);

        //what kind of garage does the user want?
        switch(iInput){
            case 1:
                //car garage
                //figure out if this garage can paint cars
                System.out.println("Can this garage paint cars? (y/n)");
                System.out.print("Selection>");
                sInput = userInput.nextLine();
                while(!(sInput.equals("y")) && !(sInput.equals("n"))){
                    System.out.println("Please select 'y' or 'n' only.");
                    System.out.print("Selection>");
                    sInput = userInput.nextLine();
                }
                if(sInput.equals("y")){
                    garages.add(new CarGarage(true));
                } else{
                    garages.add(new CarGarage(false));
                }
                System.out.println("Car garage built!");
                break;
            case 2:
                //dock
                garages.add(new Dock());
                System.out.println("Dock built!");
                break;
            case 3:
                //hangar
                garages.add(new Hangar());
                System.out.println("Hangar built!");
                break;
            default:
                //this should never happen
                System.out.println("Something went awry!");
                break;
        }
    }

    //menu option 2 allows the user to buy vehicles as long as they own a garage to store it in
    public void buyVehicle(){
        if(garages.size() == 0){
            System.out.println("\nYou don't own any garages. Please purchase a garage prior to purchasing a vehicle.");
        } else{
            System.out.println("\nSelect which type of vehicle you would like to purchase: (c/b/p)");
            System.out.print("Selection>");

            //get input for both which garage the vehicle should be stored in as well as the fuel capacity for the vehicle
            Scanner userInput = new Scanner(System.in);
            int iInput;
            String sInput = userInput.nextLine();
            while(!(sInput.equals("c")) && !(sInput.equals("b")) && !(sInput.equals("p"))){
                System.out.println("Please select 'c' or 'b' or 'p' only.");
                System.out.print("Selection>");
                sInput = userInput.nextLine();
            }

            int fuelCapacity;
            switch(sInput){
                case "c":
                    if(Utilities.anyCarGarages(garages)){
                        //figure out which carGarage and add a car to the carList in that garage
                        System.out.println("Which car garage would you like to purchase a car for?");
                        int cgIndex = ui.selectCarGarage();
                        fuelCapacity = ui.fuelCapacity();
                        String color = ui.carColor();
                        garages.get(cgIndex).buyVehicle(new Car(fuelCapacity, color));
                        System.out.println("Car purchased!");
                    } else{
                        System.out.println("You don't own any car garages.");
                    }
                    break;
                case "b":
                    if(Utilities.anyDocks(garages)){
                        //figure out which dock and add a boat to the boatList in that dock
                        System.out.println("Which dock would you like to purchase a boat for?");
                        int dIndex = ui.selectDock();
                        System.out.print("Selection>");
                        fuelCapacity = ui.fuelCapacity();
                        garages.get(dIndex).buyVehicle(new Boat(fuelCapacity));
                        System.out.println("Boat purchased!");
                    } else{
                        System.out.println("You don't own any docks.");
                    }
                    break;
                case "p":
                    if(Utilities.anyHangars(garages)){
                        //figure out which hangar and add a plane to the planeList in that hangar
                        System.out.println("Which hangar would you like to purchase a plane for?");
                        int hIndex = ui.selectHangar();
                        fuelCapacity = ui.fuelCapacity();
                        garages.get(hIndex).buyVehicle(new Plane(fuelCapacity));
                        System.out.println("Plane purchased!");
                    } else{
                        System.out.println("You don't own any hangars.");
                    }
                    break;
                //this should never happen
                default:
                    System.out.println("Something went awry!");
                    break;
            }
        }
    }

    //menu option 2 also allows a user to sell any vehicle they own
    public void sellVehicle(){
        Scanner userInput = new Scanner(System.in);
        String sInput;

        //print a list so the user can decide what to sell
        System.out.println("\nHere is a list of all of the vehicles you own:");
        Utilities.printVehiclesNoGarages(garages);
        System.out.println("Would you like to sell a car, a boat, or a plane? (c/b/p)");
        System.out.print("Selection>");
        sInput = userInput.nextLine();
        while(!(sInput.equals("c")) && !(sInput.equals("b")) && !(sInput.equals("p"))){
            System.out.println("Please select 'c' or 'b' or 'p' only.");
            System.out.print("Selection>");
            sInput = userInput.nextLine();
        }
        int cars = Utilities.calcNumCarsOwned(garages);
        int boats = Utilities.calcNumBoatsOwned(garages);
        int planes = Utilities.calcNumPlanesOwned(garages);
        switch(sInput){
            case "c":
                if(cars == 0){
                    System.out.println("You don't have any cars to sell!");
                } else{
                    System.out.println("Please select which car you would like to sell from the list (number only).");
                    Utilities.printCars(garages);
                    System.out.print("Selection>");
                    String carInput = userInput.nextLine();
                    //next we need to remove the selected car from its respective garage
                }
                break;
            case "b":
                if(boats == 0){
                    System.out.println("You don't have any boats to sell!");
                } else{
                    System.out.println("Please select which boat you would like to sell from the list (number only).");
                    Utilities.printBoats(garages);
                    System.out.print("Selection>");
                    String boatInput = userInput.nextLine();
                    //next we need to remove the selected boat from its respective dock
                }
                break;
            case "p":
                if(planes == 0){
                    System.out.println("You don't have any planes to sell!");
                } else{
                    System.out.println("Please select which plane you would like to sell from the list (number only).");
                    Utilities.printPlanes(garages);
                    System.out.print("Selection>");
                    String planeInput = userInput.nextLine();
                    //next we need to remove the selected plane from its respective hangar
                }
                break;
            //this should never happen
            default:
                System.out.println("Something went awry!");
                break;
        }
    }

    //menu option 3 allows a user to remove a vehicle from its garage
    public void removeVehicle(){ System.out.println("\nMethod not written yet."); }

    //menu option 4 allows a user to bring a vehicle back to its garage
    public void returnVehicle(){ System.out.println("\nMethod not written yet."); }

    //menu option 5 allows the user to display a list of the garages that they have built
    public void printGarages(){
        System.out.println();
        Utilities.printCarGarages(garages);
        Utilities.printDocks(garages);
        Utilities.printHangars(garages);
    }

    //menu option 6 allows the user to display a list of the vehicles that they own regardless of whether or not
    //they are currently in the garage
    public void printVehicles(){
        if(garages.isEmpty()){
            System.out.println("\nList of garages and their vehicles:");
            Utilities.printCars(garages);
            Utilities.printBoats(garages);
            Utilities.printPlanes(garages);
        }else {
            System.out.println("\nYou don't own any garages or vehicles.");
        }
    }

    //menu option 7 allows a user to paint a car a different color
    public void paintCar(){ System.out.println("\nMethod not written yet."); }

    //menu option 8 allows a user to end the day and complete daily maintenance
    public void endDay(){ System.out.println("\nMethod not written yet."); }
}