import java.util.LinkedList;
import java.util.List;

/**
 * Created by jordan on 4/16/2016.
 */
public class CarGarage extends Garage {
    /**
    Car garage: Some of the car garages will have a paint sprayer and can repaint cars.  If it does have a
    sprayer it can change a car’s color.
    */
    //car garages need to be able to decide if they can paint a car, and they need to to have a collection of cars
    private boolean paintSprayer;
    private List<Car> carList;

    //build the car garage
    CarGarage(boolean paintSprayer){
        super(GarageType.ground);
        this.paintSprayer = paintSprayer;
        carList = new LinkedList<>();
    }

    //accessors
    public boolean canPaintcars(){ return this.paintSprayer; }
    public List<Car> getCarList(){ return this.carList; }

    //override the garage buyVehicle method
    public void buyCar(Car c){ carList.add(c); }

    //check to see if the garage is empty
    public boolean isEmpty(){
        boolean empty = false;
        if(carList.size() == 0){
            empty = true;
        }
        return empty;
    }
}
