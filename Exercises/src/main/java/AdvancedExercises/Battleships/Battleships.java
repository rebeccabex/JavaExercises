package AdvancedExercises.Battleships;

public class Battleships {

    public Battleships() {

        Grid p1grid = new Grid(3);
        ShipSet p1Ships = new ShipSet();

        Ship shipToPlace = p1Ships.nextShipToPlace();

        while (shipToPlace != null) {
            boolean placed = p1grid.placeShip(shipToPlace,2,1, true);
            if (!placed) {
                System.out.println("Invalid ship placement");
                break;
            }
            shipToPlace = p1Ships.nextShipToPlace();
        }


        System.out.println(p1grid.gridToString());

    }

    public static void main(String[] args) {
        Battleships battleships = new Battleships();
    }



}

