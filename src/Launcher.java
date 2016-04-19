/**
 * Created by jordan on 4/16/2016.
 */
public class Launcher {
    /**
     The task here is to create a system for keeping track of a very wealthy individual's vehicle collection.

     This person has a series of garages and vehicles that you will have to maintain.

     Garages: Every garage will have a type (air, water, or ground) and it can only house a vehicle of the same type.
              Every night all the vehicles in the garages will need to have their tanks filled (by order of the owner).

     Some special functions of each garage:

     1. Hangers: In order to pull a plane from a hanger a ground vehicle from another garage will have to be used to
                 pull the plane out.  This will consume one fuel from the ground vehicle but will return the vehicle
                 to its garage instantly.
     2. Docks: Every evening if a boat is over a week without cleaning it will be raised out of the water and cleaned.
     3. Car garage: Some of the car garages will have a paint sprayer and can repaint cars.  If it does have a
                    sprayer it can change a car’s color.

     Vehicles: Every vehicle will have a type (like the garages), a variable for fuel tank capacity, and a variable
               for the fuel.

     Some special functions of each vehicle:

     1. Plane: Every time the plane is taken out there is a one in four chance a bird will have to be cleaned off it.
               If this happens the plane must remain grounded the rest of the day.
     2. Boat: The boats must keep track of how many days it’s been since the last cleaning of the hull.
     3. Cars: Must keep track of color, but color can only change in a garage with a paint sprayer.

     UI:
     The UI can do a few things:
     1.  Take a vehicle out on the road (user will input fuel consumption).
     2.  Display vehicles (both in and out).
     3.  Display garages with vehicles.
     4.  Return vehicle from the road to a garage.
     5.  Let a day pass (refuel all vehicle plus maintenance, and total fuel needed for refuel should be displayed).
     6.  Build a garage.
     7.  Buy/sell a vehicle.
     8.  Recolor a car.
     9.  Exit.

     The UI can be something simple inside the console, but should be easy to understand.
     */
    public static void main(String[] args){
        //all we're doing here is building the menu, the rest of the functionality will be contained in either
        //the Menu class for the menu itself or the MenuMethods class for the actual tasks the menu is able to perform
        Menu m = new Menu();
        m.buildMenu();
    }
}
