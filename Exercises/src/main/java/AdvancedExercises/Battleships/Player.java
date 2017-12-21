package AdvancedExercises.Battleships;

public abstract class Player {

    protected int playerNo;
    protected Grid shipGrid;
    protected Grid targetGrid;
    protected ShipSet shipSet;

    public Player(int playerNo, int gridSize) {
        this.playerNo = playerNo;
        shipGrid = new Grid(gridSize);
        targetGrid = new Grid(gridSize);
        shipSet = new ShipSet();
    }

    public abstract boolean setup();

    public abstract boolean placeShip(Ship shipToPlace, int[] inputCoord, String orientationLetter);

    public abstract int[] takeTurn();

    public Ship nextShipToPlace() {
        return shipSet.nextShipToPlace();
    }

    public abstract int shotOutcome(int[] inputCoord, int outcome);

    public abstract int opponentShot(int[] inputCoord);

    public boolean hasPlayerLost() {
        return shipSet.allShipsSunk();
    }

    public String getShipGridString() {
        return shipGrid.gridToString();
    }

    public String getTargetGridString() {
        return targetGrid.gridToString();
    }
}
