import java.util.Random;

/**
 * Created by jordan on 4/16/2016.
 */
public class Plane extends Vehicle {
    //Plane: Every time the plane is taken out there is a one in four chance a bird will have to be cleaned off it.
    private boolean grounded;

    //build the plane
    Plane(int fuelCapacity){
        super(fuelCapacity, VehicleType.plane);
        this.grounded = false;
    }

    //accessors
    public boolean isGrounded(){ return this.grounded; }

    //planes require a check every time they go out to see if they need to be cleaned
    public void cleaningRequired(){
        //make an object so that we can create a random number between 1 and 4
        Random r = new Random();
        int max = 4, min = 1;

        //fill the random number for values 1-4 only
        int random = r.nextInt(max - min + 1) + min;

        //if the random number is 1 we gotta clean her up, otherwise we just return the default value of false
        if(random == 1){
            grounded = true;
        }
    }
}
