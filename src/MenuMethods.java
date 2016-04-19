import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jordan on 4/16/2016.
 */
public class MenuMethods {
    //this class contains all the methods needed to interface with our garages/vehicles via the ui menu
    //it also contains the lists of different object we need to be able to interact with
    private static List<CarGarage> carGarages = new LinkedList<>();
    private static List<Dock> docks = new LinkedList<>();
    private static List<Hangar> hangars = new LinkedList<>();

    //menu option 1 allows the user to build any type of garage
    public void buildGarage(){
        System.out.println("\nSelect the type of garage you would like to build (number only):");
        System.out.println("(1) Car Garage");
        System.out.println("(2) Dock");
        System.out.println("(3) Hangar");
        System.out.print("Selection>");

        //create an input variable
        Scanner userInput = new Scanner(System.in);
        int input;
        String sInput;
        sInput = userInput.nextLine();
        while(!(Menu.isInt(sInput))){
            System.out.println("Please only input numeric values.");
            System.out.print("Selection>");
            sInput = userInput.nextLine();
        }
        input = Integer.parseInt(sInput);
        while(input < 1 || input > 3){
            System.out.println("Please select a number between 1 and 3.");
            System.out.print("Selection>");
            sInput = userInput.nextLine();
            while(!(Menu.isInt(sInput))){
                System.out.println("Please only input numeric values.");
                System.out.print("Selection>");
                sInput = userInput.nextLine();
            }
            input = Integer.parseInt(sInput);
        }

        //what kind of garage does the user want?
        switch(input){
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
                    carGarages.add(new CarGarage(true));
                } else{
                    carGarages.add(new CarGarage(false));
                }
                System.out.println("Car garage built!");
                break;
            case 2:
                //dock
                docks.add(new Dock());
                System.out.println("Dock built!");
                break;
            case 3:
                //hangar
                hangars.add(new Hangar());
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
        if(carGarages.size() == 0 && docks.size() == 0 && hangars.size() == 0){
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
                    if(!(carGarages.isEmpty())){
                        //figure out which carGarage and add a car to the carList in that garage
                        System.out.println("Which car garage would you like to purchase a car for?");
                        printCarGarages();
                        System.out.print("Selection>");
                        sInput = userInput.nextLine();
                        while(!(Menu.isInt(sInput))){
                            System.out.println("Please only input numeric values.");
                            System.out.print("Selection>");
                            sInput = userInput.nextLine();
                        }
                        iInput = Integer.parseInt(sInput);
                        while(iInput < 1 || iInput > carGarages.size()){
                            System.out.println("Please select a number between 1 and " + carGarages.size() + ".");
                            System.out.print("Selection>");
                            sInput = userInput.nextLine();
                            while(!(Menu.isInt(sInput))){
                                System.out.println("Please only input numeric values.");
                                System.out.print("Selection>");
                                sInput = userInput.nextLine();
                            }
                            iInput = Integer.parseInt(sInput);
                        }

                        fuelCapacity = getFuelCapacity();
                        String color = getCarColor();
                        carGarages.get(iInput - 1).buyVehicle(new Car(fuelCapacity, color));
                        System.out.println("Car purchased!");
                    } else{
                        System.out.println("You don't own any car garages.");
                    }
                    break;
                case "b":
                    if(!(docks.isEmpty())){
                        //figure out which dock and add a boat to the boatList in that dock
                        System.out.println("Which dock would you like to purchase a boat for?");
                        printDocks();
                        System.out.print("Selection>");
                        sInput = userInput.nextLine();
                        while(!(Menu.isInt(sInput))){
                            System.out.println("Please only input numeric values.");
                            System.out.print("Selection>");
                            sInput = userInput.nextLine();
                        }
                        iInput = Integer.parseInt(sInput);
                        while(iInput < 1 || iInput > docks.size()){
                            System.out.println("Please select a number between 1 and " + docks.size() + ".");
                            System.out.print("Selection>");
                            sInput = userInput.nextLine();
                            while(!(Menu.isInt(sInput))){
                                System.out.println("Please only input numeric values.");
                                System.out.print("Selection>");
                                sInput = userInput.nextLine();
                            }
                            iInput = Integer.parseInt(sInput);
                        }

                        fuelCapacity = getFuelCapacity();
                        docks.get(iInput - 1).buyVehicle(new Boat(fuelCapacity));
                        System.out.println("Boat purchased!");
                    } else{
                        System.out.println("You don't own any docks.");
                    }
                    break;
                case "p":
                    if(!(hangars.isEmpty())){
                        //figure out which hangar and add a plane to the planeList in that hangar
                        System.out.println("Which hangar would you like to purchase a plane for?");
                        printHangars();
                        System.out.print("Selection>");
                        sInput = userInput.nextLine();
                        while(!(Menu.isInt(sInput))){
                            System.out.println("Please only input numeric values.");
                            System.out.print("Selection>");
                            sInput = userInput.nextLine();
                        }
                        iInput = Integer.parseInt(sInput);
                        while(iInput < 1 || iInput > hangars.size()){
                            System.out.println("Please select a number between 1 and " + hangars.size() + ".");
                            System.out.print("Selection>");
                            sInput = userInput.nextLine();
                            while(!(Menu.isInt(sInput))){
                                System.out.println("Please only input numeric values.");
                                System.out.print("Selection>");
                                sInput = userInput.nextLine();
                            }
                            iInput = Integer.parseInt(sInput);
                        }

                        fuelCapacity = getFuelCapacity();
                        hangars.get(iInput - 1).buyVehicle(new Plane(fuelCapacity));
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
        printVehiclesNoGarages();
        System.out.println("Would you like to sell a car, a boat, or a plane? (c/b/p)");
        System.out.print("Selection>");
        sInput = userInput.nextLine();
        while(!(sInput.equals("c")) && !(sInput.equals("b")) && !(sInput.equals("p"))){
            System.out.println("Please select 'c' or 'b' or 'p' only.");
            System.out.print("Selection>");
            sInput = userInput.nextLine();
        }
        int cars = calcNumCarsOwned();
        int boats = calcNumBoatsOwned();
        int planes = calcNumPlanesOwned();
        switch(sInput){
            case "c":
                if(cars == 0){
                    System.out.println("You don't have any cars to sell!");
                } else{
                    System.out.println("Please select which car you would like to sell from the list (number only).");
                    printCars();
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
                    printBoats();
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
                    printPlanes();
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
    public void removeVehicle(){
        System.out.println("\nMethod not written yet.");
    }

    //menu option 4 allows a user to bring a vehicle back to its garage
    public void returnVehicle(){
        System.out.println("\nMethod not written yet.");
    }

    //menu option 5 allows the user to display a list of the garages that they have built
    public void printGarages(){
        System.out.println();
        printCarGarages();
        printDocks();
        printHangars();
    }

    //want this to be reusable
    private void printCarGarages(){
        int i = 1;
        if(!(carGarages.isEmpty())){
            System.out.println("List of car garages you own:");
            for(CarGarage cg: carGarages){
                if(cg.getPaintSprayer()){
                    System.out.println("\t(" + i + ") Car Garage (Can paint cars)");
                } else{
                    System.out.println("\t(" + i + ") Car Garage (Cannot paint cars)");
                }
                i++;
            }
        } else{
            System.out.println("You don't own any car garages.");
        }
    }

    //want this to be reusable
    private void printDocks(){
        int i = 1;
        if(!(docks.isEmpty())){
            System.out.println("List of docks you own:");
            for(Dock d: docks){
                System.out.println("\t(" + i + ") Dock");
                i++;
            }
        }else {
            System.out.println("You don't own any docks.");
        }
    }

    //want this to be reusable
    private void printHangars(){
        int i = 1;
        if(!(hangars.isEmpty())){
            System.out.println("List of hangars you own:");
            for(Hangar h: hangars){
                System.out.println("\t(" + i + ") Hangar");
                i++;
            }
        }else {
            System.out.println("You don't own any hangars.");
        }
    }

    //menu option 6 allows the user to display a list of the vehicles that they own regardless of whether or not
    //they are currently in the garage
    public void printVehicles(){
        if(calcTotalGarages() != 0){
            System.out.println("\nList of garages and their vehicles:");
            printCars();
            printBoats();
            printPlanes();
        }else {
            System.out.println("\nYou don't own any garages or vehicles.");
        }
    }

    //want this to be reusable
    private static void printCars(){
        int i = 1;
        int j = 1;
        if(!(carGarages.isEmpty())){
            for(CarGarage cg: carGarages){
                System.out.println("\t(" + i + ") Car Garage");
                if(!(cg.getCarList().isEmpty())){
                    for (Car c : cg.getCarList()){
                        if (c.isOut()) {
                            System.out.println("\t\t(" + j + ") Car (" + c.getColor() + ") (Out of garage)");
                        } else {
                            System.out.println("\t\t(" + j + ") Car (" + c.getColor() + ") (In garage)");
                        }
                        j++;
                    }
                    j = 1;
                } else{
                    System.out.println("\t\tThis garage is empty.");
                }
                i++;
            }
        } else{
            System.out.println("You don't own any car garages.");
        }
    }

    //want this to be reusable
    private static void printBoats(){
        int i = 1;
        int j = 1;
        if(!(docks.isEmpty())){
            for(Dock d: docks){
                System.out.println("\t(" + i + ") Dock");
                if (!(d.getBoatList().isEmpty())){
                    for (Boat b: d.getBoatList()){
                        if (b.isOut()) {
                            System.out.println("\t\t(" + j + ") Boat (Out of dock)");
                        } else {
                            System.out.println("\t\t(" + j + ") Boat (In dock)");
                        }
                        j++;
                    }
                    j = 1;
                } else{
                    System.out.println("\t\tThis dock is empty.");
                }
                i++;
            }
        } else{
            System.out.println("You don't own any docks.");
        }
    }

    //want this to be reusable
    private static void printPlanes(){
        int i = 1;
        int j = 1;
        if(!(hangars.isEmpty())){
            for(Hangar h: hangars){
                System.out.println("\t(" + i + ") Hangar");
                if(!(h.getPlaneList().isEmpty())){
                    for(Plane p: h.getPlaneList()){
                        if(p.isOut()){
                            System.out.println("\t\t(" + j + ") Plane (Out of hangar)");
                        } else{
                            System.out.println("\t\t(" + j + ") Plane (In hangar)");
                        }
                        j++;
                    }
                    j = 1;
                } else{
                    System.out.println("\t\tThis hangar is empty.");
                }
                i++;
            }
        }
        else{
            System.out.println("You don't own any hangars.");
        }
    }

    //menu option 7 allows a user to paint a car a different color
    public void paintCar(){
        System.out.println("\nMethod not written yet.");
    }

    //menu option 8 allows a user to end the day and complete daily maintenance
    public void endDay(){
        System.out.println("\nMethod not written yet.");
    }

    //want this to be reusable
    private static void printVehiclesNoGarages(){
        int i = 1;
        System.out.println("Cars:");
        if(!(calcNumCarsOwned() == 0)){
            for(CarGarage cg: carGarages){
                for(Car c: cg.getCarList()){
                    if(c.isOut()){
                        System.out.println("\t(" + i + ") Car (" + c.getColor() + ") (Out of garage)");
                    } else{
                        System.out.println("\t(" + i + ") Car (" + c.getColor() + ") (In garage)");
                    }
                }
            }
        } else{
            System.out.println("\tYou don't own any cars.");
        }
        i = 1;
        System.out.println("Boats:");
        if(!(calcNumBoatsOwned() == 0)){
            for(Dock d: docks){
                for(Boat b: d.getBoatList()){
                    if(b.isOut()){
                        System.out.println("\t(" + i + ") Boat (Out of dock)" );
                    } else{
                        System.out.println("\t(" + i + ") Boat (In dock)" );
                    }
                }
            }
        } else{
            System.out.println("\tYou don't own any boats.");
        }
        i = 1;
        System.out.println("Planes:");
        if(!(calcNumPlanesOwned() == 0)){
            for(Hangar h: hangars){
                for(Plane p: h.getPlaneList()){
                    if(p.isOut()){
                        System.out.println("\t(" + i + ") Plane (Out of hangar)" );
                    } else{
                        System.out.println("\t(" + i + ") Plane (In hangar)" );
                    }
                }
            }
        } else{
            System.out.println("\tYou don't own any planes.");
        }
    }

    //want this to be reusable
    private static int calcTotalGarages(){
        return (carGarages.size() + docks.size() + hangars.size());
    }

    //want this to be reusable
    private static int getFuelCapacity(){
        Scanner userInput = new Scanner(System.in);
        int fuelCapacity;
        //fuelCapacity input
        System.out.println("What is the fuel capacity for this vehicle?");
        System.out.print("Selection>");
        String sInput = userInput.nextLine();
        while(!(Menu.isInt(sInput))){
            System.out.println("Please only input numeric values.");
            System.out.print("Selection>");
            sInput = userInput.nextLine();
        }
        fuelCapacity = Integer.parseInt(sInput);
        while(fuelCapacity < 1){
            System.out.println("Please select a number greater than 0");
            System.out.print("Selection>");
            sInput = userInput.nextLine();
            while(!(Menu.isInt(sInput))){
                System.out.println("Please only input numeric values.");
                System.out.print("Selection>");
                sInput = userInput.nextLine();
            }
            fuelCapacity = Integer.parseInt(sInput);
        }
        return fuelCapacity;
    }

    //want this to be reusable, will reuse when repainting a car
    private static String getCarColor(){
        Scanner userInput = new Scanner(System.in);
        System.out.println("What color would you like your car to be?");
        System.out.print("Selection (any color)>");
        String color = userInput.nextLine();
        while(Menu.isInt(color)){
            System.out.println("Please choose a non-numeric color.");
            System.out.print("Selection (any color)>");
            color = userInput.nextLine();
        }
        return color;
    }

    //want this to be reusable
    private static int calcNumCarsOwned(){
        int numCars = 0;
        for(CarGarage cg: carGarages){
            for(Car c: cg.getCarList()){
                numCars++;
            }
        }
        return numCars;
    }

    //want this to be reusable
    private static int calcNumBoatsOwned(){
        int numBoats = 0;
        for(Dock d: docks){
            for(Boat b: d.getBoatList()){
                numBoats++;
            }
        }
        return numBoats;
    }

    //want this to be reusable
    private static int calcNumPlanesOwned(){
        int numPlanes = 0;
        for(Hangar h: hangars){
            for(Plane p: h.getPlaneList()){
                numPlanes++;
            }
        }
        return numPlanes;
    }
}