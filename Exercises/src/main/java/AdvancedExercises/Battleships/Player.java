package AdvancedExercises.Battleships;

public class Player {

    private Grid shipGrid;
    private ShipSet shipSet;

    public Player(int gridSize) {
        shipGrid = new Grid(gridSize);
        shipSet = new ShipSet();
    }

    public boolean placeShip(Ship shipToPlace, int[] inputCoord, String orientationLetter) {

        boolean orientation = orientationLetter.equalsIgnoreCase("v");

        return shipGrid.placeShip(shipToPlace, inputCoord[0], inputCoord[1], orientation);
    }

    public Ship nextShipToPlace() {
        return shipSet.nextShipToPlace();
    }

    public int takeShot(int[] inputCoord) {

        int x = inputCoord[0];
        int y = inputCoord[1];

        int actionValue = shipGrid.targetCoordinates(x, y);

        if (actionValue == 1) {
            Ship hitShip = shipSet.whichShipHit(x, y);
            if (shipSet.isShipSunk(hitShip)) {
                if (hasPlayerLost()) {
                    actionValue = 5;
                } else {
                    actionValue = 4;
                }
            }
        }
        return actionValue;
    }

    public boolean hasPlayerLost() {
        return shipSet.allShipsSunk();
    }

    public String getShipGridString() {
        return shipGrid.gridToString();
    }
}
