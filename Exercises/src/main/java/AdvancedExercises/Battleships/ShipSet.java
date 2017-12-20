package AdvancedExercises.Battleships;

import java.util.ArrayList;

public class ShipSet {

    ArrayList<Ship> shipList;

    public ShipSet() {

        shipList = new ArrayList<>();

        Ship patrolBoat1 = new Ship("Patrol Boat", 2);
        shipList.add(patrolBoat1);

        Ship patrolBoat2 = new Ship("Patrol Boat", 2);
        shipList.add(patrolBoat2);

    }

    public Ship nextShipToPlace() {

        for (Ship s : shipList) {
            if (!s.isPlaced()) {
                return s;
            }
        }
        return null;
    }

}
