package AdvancedExercises.Battleships;

public class Player {

    private Grid shipGrid;
    private ShipSet shipSet;

    public Player(int gridSize) {
        shipGrid = new Grid(gridSize);
        shipSet = new ShipSet();
    }

    public boolean placeShips(int[][] initPlaces) {
        Ship shipToPlace = shipSet.nextShipToPlace();

        boolean placed = shipGrid.placeShip(shipToPlace, initPlaces[0][0], initPlaces[0][1], true);
        if (!placed) {
            System.out.println("Invalid ship placement");
        }

        shipToPlace = shipSet.nextShipToPlace();
        placed = shipGrid.placeShip(shipToPlace, initPlaces[1][0], initPlaces[1][1], false);
        if (!placed) {
            System.out.println("Invalid ship placement");
        }

        return true;
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
