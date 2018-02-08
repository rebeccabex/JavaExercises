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

    public void shotOutcome(int[] inputCoord, GridSpace outcome) {

        boolean hit = false;

        if (!outcome.equals(GridSpace.EMPTY)) {
            hit = true;
        }

        targetGrid.updateGridSpace(inputCoord[0], inputCoord[1], hit);
    }

    public GridSpace opponentShot(int[] inputCoord) {

        int x = inputCoord[0];
        int y = inputCoord[1];

        GridSpace actionValue = shipGrid.targetCoordinates(x, y);

        if (actionValue.equals(GridSpace.EMPTY)) {
            shipGrid.updateGridSpace(x, y, false);
        } else if (actionValue.equals(GridSpace.SHIP)) {
            shipGrid.updateGridSpace(x, y, true);
        }

        if (actionValue.equals(GridSpace.SHIP)) {
            Ship hitShip = shipSet.whichShipHit(x, y);
            if (shipSet.isShipSunk(hitShip)) {
                if (hasPlayerLost()) {
                    actionValue = GridSpace.WON;
                } else {
                    actionValue = GridSpace.SUNK;
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
