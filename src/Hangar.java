import java.util.LinkedList;
import java.util.List;

/**
 * Created by jordan on 4/16/2016.
 */
public class Hangar extends Garage{
    /**
    Hangers: In order to pull a plane from a hanger a ground vehicle from another garage will have to be used to
             pull the plane out.  This will consume one fuel from the ground vehicle but will return the vehicle
             to its garage instantly.
     */
    //hangars need to have a collection of planes
    private static List<Plane> planeList;

    //build the hanger
    Hangar(){
        super(GarageType.air);
        planeList = new LinkedList<>();
    }

    //accessors
    public List<Plane> getPlaneList(){ return this.planeList; }

    //override the garage buyVehicle method
    public void buyPlane(Plane p){
        planeList.add(p);
    }

    public void flyPlane(Car c){ c.towPlane(); }

    //check to see if the garage is empty
    public boolean isEmpty(){
        boolean empty = false;
        if(planeList.size() == 0){
            empty = true;
        }
        return empty;
    }
}
