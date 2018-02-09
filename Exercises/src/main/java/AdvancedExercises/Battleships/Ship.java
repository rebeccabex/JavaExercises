package AdvancedExercises.Battleships;

public class Ship {

    private String name;
    private int size;
    private Coordinates[] shipCoords;
    private boolean placed;
    private int hits;
    private boolean sunk;

    public Ship(String name, int size) {

        this.name = name;
        this.size = size;
        shipCoords = new Coordinates[size];
        placed = false;
        hits = 0;
        sunk = false;

    }

    public void placeShip(Coordinates coords, boolean northToSouth) {

        for (int i = 0; i < size; i++) {
            Coordinates addCoords;
            if (northToSouth) {
                addCoords = new Coordinates(coords.getX(), coords.getY() + 1);
            } else {
                addCoords = new Coordinates(coords.getX() + 1, coords.getY());
            }
            shipCoords[i] = addCoords;
        }

        placed = true;
    }

    public boolean shipHit(Coordinates coords) {

        for (int i = 0; i < size; i++) {
            if (shipCoords[i].equals(coords)) {
                hits++;
                return true;
            }
        }
        return false;
    }

    public boolean shipSunk() {
        return size == hits;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public Coordinates[] getShipCoords() {
        return shipCoords;
    }

    public boolean isSunk() {
        return sunk;
    }

    public boolean isPlaced() {
        return placed;
    }
}
