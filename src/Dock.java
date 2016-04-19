import java.util.LinkedList;
import java.util.List;

/**
 * Created by jordan on 4/16/2016.
 */
public class Dock extends Garage {
    //Docks: Every evening if a boat is over a week without cleaning it will be raised out of the water and cleaned.
    //docks need to have a collection of boats
    private static List<Boat> boatList;

    //build the dock
    Dock(){
        super(GarageType.water);
        boatList = new LinkedList<>();
    }

    //accessors
    public List<Boat> getBoatList(){ return this.boatList; }

    //gotta be able to clean those boats if it's been over a week
    public void cleanBoat(Boat b){
        //reset the timer
        b.setDaysSinceCleaning(0);
    }

    //override the garage buyVehicle method
    public void buyVehicle(Boat b){
        boatList.add(b);
    }

    //check to see if the garage is empty
    public boolean isEmpty(){
        boolean empty = false;
        if(boatList.size() == 0){
            empty = true;
        }
        return empty;
    }
}
