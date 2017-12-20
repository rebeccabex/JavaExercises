package AdvancedExercises.Battleships;

public class Player {

    private Grid shipGrid;
    private ShipSet shipSet;

    public Player(int gridSize) {
        shipGrid = new Grid(gridSize);
        shipSet = new ShipSet();
    }

    // will edit when implement ability for user to input ship's places
    public boolean placeShips(int[][] initPlaces, boolean[] initOrientations) {
        Ship shipToPlace = shipSet.nextShipToPlace();

        for (int i = 0; i < initOrientations.length; i++) {
            boolean placed = shipGrid.placeShip(shipToPlace, initPlaces[i][0], initPlaces[i][1], initOrientations[i]);
            if (!placed) {
                System.out.println("Invalid ship placement");
            }
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
