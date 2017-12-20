package AdvancedExercises.Battleships;

import java.util.ArrayList;

public class ShipSet {

    ArrayList<Ship> shipList;

    public ShipSet() {

        shipList = new ArrayList<>();

        Ship patrolBoat = new Ship("Patrol Boat", 2);

        shipList.add(patrolBoat);

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
