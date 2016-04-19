/**
 * Created by jordan on 4/16/2016.
 */
public class Car extends Vehicle{
    //Cars: Must keep track of color, but color can only change in a garage with a paint sprayer.
    String color;

    //build the car
    Car(int fuelCapacity, String color){
        super(fuelCapacity, VehicleType.car);
        this.color = color;
    }

    //accessors
    public String getColor(){ return this.color; }

    //gotta be able to paint the car, this should only ever occur if the car is in a CarGarage with its paintSprayer
    //flag set to true
    public void paintCar(String color){ this.color = color; }

    //a car is required to tow a plane out of its garage. this consumes one fuel but returns the car to the garage
    //instantly
    public void towPlane(){
        setCurrentFuel(getCurrentFuel() - 1);
    }
}
