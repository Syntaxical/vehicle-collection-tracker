/**
 * Created by jordan on 4/16/2016.
 */
public class Boat extends Vehicle {
    //Boat: The boats must keep track of how many days it’s been since the last cleaning of the hull.
    int daysSinceCleaning;

    //build the boat
    Boat(int fuelCapacity){
        super(fuelCapacity, VehicleType.boat);
        this.daysSinceCleaning =  0;
    }

    //accessors
    public int getDaysSinceCleaning(){ return this.daysSinceCleaning; }

    //mutators
    public void cleanBoat(){ this.daysSinceCleaning = 0; }

    //any time a day passes we need to call this method for each boat in our garage
    public void boatDayPasses(){ this.daysSinceCleaning++; }
}
