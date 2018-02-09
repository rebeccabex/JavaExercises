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

    public abstract Coordinates takeTurn();

    public Ship nextShipToPlace() {
        return shipSet.nextShipToPlace();
    }

    public void shotOutcome(Coordinates inputCoord, GridSpace outcome) {

        boolean hit = false;

        if (!outcome.equals(GridSpace.EMPTY)) {
            hit = true;
        }

        targetGrid.updateGridSpace(inputCoord, hit);
    }

    public GridSpace opponentShot(Coordinates inputCoord) {

        GridSpace actionValue = shipGrid.targetCoordinates(inputCoord);

        if (actionValue.equals(GridSpace.EMPTY)) {
            shipGrid.updateGridSpace(inputCoord, false);
        } else if (actionValue.equals(GridSpace.SHIP)) {
            shipGrid.updateGridSpace(inputCoord, true);
        }

        if (actionValue.equals(GridSpace.SHIP)) {
            Ship hitShip = shipSet.whichShipHit(inputCoord);

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
