import java.util.List;

/**
 * Created by jfnothstine on 4/26/2016.
 */
public class Utilities {

    public static boolean anyCarGarages(List<Garage> garages){
        boolean found = false;
        for(Garage cg: garages){
            if(cg instanceof CarGarage){
                found = true;
            }
        }
        return found;
    }

    public static boolean anyDocks(List<Garage> garages){
        boolean found = false;
        for(Garage d: garages){
            if(d instanceof Dock){
                found = true;
            }
        }
        return found;
    }

    public static boolean anyHangars(List<Garage> garages){
        boolean found = false;
        for(Garage h: garages){
            if(h instanceof Hangar){
                found = true;
            }
        }
        return found;
    }

    public static void printCarGarages(List<Garage> garages){
        int i = 1;
        if(anyCarGarages(garages)){
            System.out.println("List of car garages you own:");
            for(Garage cg: garages){
                if(cg instanceof CarGarage){
                    if(((CarGarage) cg).canPaintcars()){
                        System.out.println("\t(" + i + ") Car Garage (Can paint cars)");
                    } else{
                        System.out.println("\t(" + i + ") Car Garage (Cannot paint cars)");
                    }
                }
                i++;
            }
        } else{
            System.out.println("You don't own any car garages.");
        }
    }

    public static void printDocks(List<Garage> garages){
        int i = 1;
        if(anyDocks(garages)){
            System.out.println("List of docks you own:");
            for(Garage d: garages){
                if(d instanceof Dock){
                    System.out.println("\t(" + i + ") Dock");
                }
                i++;
            }
        } else{
            System.out.println("You don't own any docks.");
        }
    }

    public static void printHangars(List<Garage> garages){
        int i = 1;
        if(anyHangars(garages)){
            System.out.println("List of hangars you own:");
            for(Garage h: garages){
                if(h instanceof Hangar){
                    System.out.println("\t(" + i + ") Hangar");
                }
                i++;
            }
        } else{
            System.out.println("You don't own any hangars.");
        }
    }

    public static void printCars(List<Garage> garages){
        int i = 1;
        int j = 1;
        if(anyCarGarages(garages)){
            for(Garage cg: garages){
                if(cg instanceof CarGarage){
                    System.out.println("\t(" + i + ") Car Garage");
                    if(!(cg.isEmpty())){
                        for(Car c: ((CarGarage) cg).getCarList()){
                            if (c.isOut()) {
                                System.out.println("\t\t(" + j + ") Car (" + c.getColor() + ") (Out of garage)");
                            } else {
                                System.out.println("\t\t(" + j + ") Car (" + c.getColor() + ") (In garage)");
                            }
                            j++;
                        }
                        j = 1;
                    } else{
                        System.out.println("\t\tThis garage is empty.");
                    }
                }
                i++;
            }
        } else{
            System.out.println("You don't own any car garages.");
        }
    }

    public static void printBoats(List<Garage> garages){
        int i = 1;
        int j = 1;
        if(anyDocks(garages)){
            for(Garage d: garages){
                if(d instanceof Dock){
                    System.out.println("\t(" + i + ") Dock");
                    if (!(d.isEmpty())){
                        for (Boat b: ((Dock) d).getBoatList()){
                            if (b.isOut()) {
                                System.out.println("\t\t(" + j + ") Boat (Out of dock)");
                            } else {
                                System.out.println("\t\t(" + j + ") Boat (In dock)");
                            }
                            j++;
                        }
                        j = 1;
                    } else{
                        System.out.println("\t\tThis dock is empty.");
                    }
                }
                i++;
            }
        } else{
            System.out.println("You don't own any docks.");
        }
    }

    public static void printPlanes(List<Garage> garages){
        int i = 1;
        int j = 1;
        if(anyHangars(garages)){
            for(Garage h: garages){
                if(h instanceof Hangar){
                    System.out.println("\t(" + i + ") Hangar");
                    if(!(h.isEmpty())){
                        for(Plane p: ((Hangar) h).getPlaneList()){
                            if(p.isOut()){
                                System.out.println("\t\t(" + j + ") Plane (Out of hangar)");
                            } else{
                                System.out.println("\t\t(" + j + ") Plane (In hangar)");
                            }
                            j++;
                        }
                        j = 1;
                    } else{
                        System.out.println("\t\tThis hangar is empty.");
                    }
                    i++;
                }
            }
        }
        else{
            System.out.println("You don't own any hangars.");
        }
    }

    public static void printVehiclesNoGarages(List<Garage> garages){
        int i = 1;
        System.out.println("Cars:");
        if(!(calcNumCarsOwned() == 0)){
            for(CarGarage cg: carGarages){
                for(Car c: cg.getCarList()){
                    if(c.isOut()){
                        System.out.println("\t(" + i + ") Car (" + c.getColor() + ") (Out of garage)");
                    } else{
                        System.out.println("\t(" + i + ") Car (" + c.getColor() + ") (In garage)");
                    }
                }
            }
        } else{
            System.out.println("\tYou don't own any cars.");
        }
        i = 1;
        System.out.println("Boats:");
        if(!(calcNumBoatsOwned() == 0)){
            for(Dock d: docks){
                for(Boat b: d.getBoatList()){
                    if(b.isOut()){
                        System.out.println("\t(" + i + ") Boat (Out of dock)" );
                    } else{
                        System.out.println("\t(" + i + ") Boat (In dock)" );
                    }
                }
            }
        } else{
            System.out.println("\tYou don't own any boats.");
        }
        i = 1;
        System.out.println("Planes:");
        if(!(calcNumPlanesOwned() == 0)){
            for(Hangar h: hangars){
                for(Plane p: h.getPlaneList()){
                    if(p.isOut()){
                        System.out.println("\t(" + i + ") Plane (Out of hangar)" );
                    } else{
                        System.out.println("\t(" + i + ") Plane (In hangar)" );
                    }
                }
            }
        } else{
            System.out.println("\tYou don't own any planes.");
        }
    }

    public static int calcNumCarsOwned(List<Garage> garages){
        int numCars = 0;
        for(CarGarage cg: carGarages){
            for(Car c: cg.getCarList()){
                numCars++;
            }
        }
        return numCars;
    }

    //want this to be reusable
    public static int calcNumBoatsOwned(List<Garage> garages){
        int numBoats = 0;
        for(Dock d: docks){
            for(Boat b: d.getBoatList()){
                numBoats++;
            }
        }
        return numBoats;
    }

    //want this to be reusable
    public static int calcNumPlanesOwned(List<Garage> garages){
        int numPlanes = 0;
        for(Hangar h: hangars){
            for(Plane p: h.getPlaneList()){
                numPlanes++;
            }
        }
        return numPlanes;
    }
}
