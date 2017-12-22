package AdvancedExercises.Battleships;

public abstract class Player {

    protected int playerNo;
    protected String name;
    protected Grid shipGrid;
    protected Grid targetGrid;
    protected ShipSet shipSet;

    public Player(int playerNo, String name, int gridSize) {
        this.playerNo = playerNo;
        this.name = name;
        shipGrid = new Grid(gridSize);
        targetGrid = new Grid(gridSize);
        shipSet = new ShipSet();
    }

    public abstract boolean setup();

    public abstract int[] takeTurn();

    public Ship nextShipToPlace() {
        return shipSet.nextShipToPlace();
    }

    public void shotOutcome(int[] inputCoord, int outcome) {

        boolean hit = false;

        if (outcome != 0) {
            hit = true;
        }

        targetGrid.updateGridSpace(inputCoord[0], inputCoord[1], hit);
    }

    public int opponentShot(int[] inputCoord) {

        int x = inputCoord[0];
        int y = inputCoord[1];

        int actionValue = shipGrid.targetCoordinates(x, y);

        if (actionValue == 0) {
            shipGrid.updateGridSpace(x, y, false);
        } else if (actionValue == 1) {
            shipGrid.updateGridSpace(x, y, true);
        }

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

    public String getTargetGridString() {
        return targetGrid.gridToString();
    }

    public String getName() {
        return name;
    }
}
