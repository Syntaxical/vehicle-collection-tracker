import java.util.LinkedList;
import java.util.List;

/**
 * Created by jordan on 4/16/2016.
 */
public class Garage {
    /**
    Garages: Every garage will have a type (air, water, or ground) and it can only house a vehicle of the same type.
             Every night all the vehicles in the garages will need to have their tanks filled (by order of the owner).
    */
    //garages need a type and their own vehicle list
    private GarageType type;
    private List<Vehicle> vehicleList;

    //build the garage
    Garage(GarageType type){
        this.type = type;
        vehicleList = new LinkedList<>();
    }

    //accessors
    public GarageType getGarageType(){ return this.type; }

    //we need to be able to add vehicles to any garage
    public void buyVehicle(Vehicle v){
        vehicleList.add(v);
    }

    //every night we gotta be able to refuel the vehicle
    public void refuel(Vehicle v){
        v.setCurrentFuel(v.getFuelCapacity());
    }

    //check to see if the garage is empty
    public boolean isEmpty(){
        boolean empty = false;
        if(vehicleList.size() == 0){
            empty = true;
        }
        return empty;
    }
}
