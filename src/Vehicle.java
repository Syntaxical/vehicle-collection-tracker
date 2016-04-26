/**
 * Created by jordan on 4/16/2016.
 */
public class Vehicle {
    /**
    Vehicles: Every vehicle will have a type (like the garages), a variable for fuel tank capacity, and a variable
              for the fuel.
    */
    private int fuelCapacity;
    private int currentFuel;
    private VehicleType type;
    private boolean isOut;

    Vehicle(int fuelCapacity, VehicleType type){
        this.fuelCapacity = fuelCapacity;
        this.currentFuel = fuelCapacity;
        this.type = type;
        this.isOut = false;
    }

    //accessors
    public int getFuelCapacity(){ return this.fuelCapacity; }
    public int getCurrentFuel() { return this.currentFuel; }
    public VehicleType getType(){ return this.type; }
    public boolean isOut(){ return this.isOut; }

    //mutators
    public void setCurrentFuel(int currentFuel){ this.currentFuel = currentFuel; }

    //we need to be able to remove a vehicle
    public void takeOut(){
        this.isOut = true;
    }
}
