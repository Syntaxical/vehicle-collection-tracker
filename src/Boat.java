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
    public void setDaysSinceCleaning(int daysSinceCleaning){ this.daysSinceCleaning = daysSinceCleaning; }
}
