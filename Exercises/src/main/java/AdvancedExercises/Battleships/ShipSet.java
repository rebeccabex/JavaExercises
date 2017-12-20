package AdvancedExercises.Battleships;

import java.util.ArrayList;
import java.util.Iterator;

public class ShipSet {

    ArrayList<Ship> shipList;

    public ShipSet() {

        shipList = new ArrayList<>();

        Ship patrolBoat1 = new Ship("Patrol Boat 1", 2);
        shipList.add(patrolBoat1);

        Ship patrolBoat2 = new Ship("Patrol Boat 2", 2);
        shipList.add(patrolBoat2);

        Ship destroyer1 = new Ship("Destroyer 1", 3);
        shipList.add(destroyer1);

        Ship destroyer2 = new Ship("Destroyer 2", 3);
        shipList.add(destroyer2);

        Ship submarine = new Ship("Submarine", 3);
        shipList.add(submarine);

        Ship battleship = new Ship("Battleship", 4);
        shipList.add(battleship);

        Ship carrier = new Ship("Carrier", 5);
        shipList.add(carrier);

    }

    public Ship nextShipToPlace() {

        for (Ship s : shipList) {
            if (!s.isPlaced()) {
                return s;
            }
        }
        return null;
    }

    public Ship whichShipHit(int x, int y) {

        for (Ship ship : shipList) {
            if (ship.shipHit(x, y)) {
                return ship;
            }
        }
        return null;
    }

    public boolean isShipSunk(Ship ship) {

        if (ship.shipSunk()) {
            shipList.remove(ship);
            return true;
        } else {
            return false;
        }
    }

    public boolean allShipsSunk() {
        return shipList.isEmpty();
    }

}
