import java.util.Scanner;

/**
 * Created by jfnothstine on 4/26/2016.
 */
public class UserInput {
    private static Scanner userInput = new Scanner(System.in);

    public int testIntWithinRange(String sInput, int start, int end){
        int iInput;
        while(!(isInt(sInput))){
            System.out.println("Please only input numeric values.");
            System.out.print("Selection>");
            sInput = userInput.nextLine();
        }
        iInput = Integer.parseInt(sInput);
        while(iInput < start || iInput > end){
            System.out.println("Please select a number between 1 and 9.");
            System.out.print("Selection>");
            sInput = userInput.nextLine();
            while(!(isInt(sInput))){
                System.out.println("Please only input numeric values.");
                System.out.print("Selection>");
                sInput = userInput.nextLine();
            }
            iInput = Integer.parseInt(sInput);
        }
        return iInput;
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

    public int fuelCapacity(){
        Scanner userInput = new Scanner(System.in);
        int fuelCapacity;
        //fuelCapacity input
        System.out.println("What is the fuel capacity for this vehicle?");
        System.out.print("Selection>");
        String sInput = userInput.nextLine();
        while(!(this.isInt(sInput))){
            System.out.println("Please only input numeric values.");
            System.out.print("Selection>");
            sInput = userInput.nextLine();
        }
        fuelCapacity = Integer.parseInt(sInput);
        while(fuelCapacity < 1){
            System.out.println("Please select a number greater than 0");
            System.out.print("Selection>");
            sInput = userInput.nextLine();
            while(!(this.isInt(sInput))){
                System.out.println("Please only input numeric values.");
                System.out.print("Selection>");
                sInput = userInput.nextLine();
            }
            fuelCapacity = Integer.parseInt(sInput);
        }
        return fuelCapacity;
    }

    public String carColor(){
        Scanner userInput = new Scanner(System.in);
        System.out.println("What color would you like your car to be?");
        System.out.print("Selection (any color)>");
        String color = userInput.nextLine();
        while(this.isInt(color)){
            System.out.println("Please choose a non-numeric color.");
            System.out.print("Selection (any color)>");
            color = userInput.nextLine();
        }
        return color;
    }

    public int selectCarGarage(){
        int cgIndex = 0;

        return cgIndex;
    }

    public int selectDock(){
        int cgIndex = 0;

        return cgIndex;
    }

    public int selectHangar(){
        int cgIndex = 0;

        return cgIndex;
    }
}
