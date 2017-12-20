package AdvancedExercises.Battleships;

public class Ship {

    private String name;
    private int size;
    private int[][] coordinates;
    private boolean placed;
    private int hits;
    private boolean sunk;

    public Ship(String name, int size) {

        this.name = name;
        this.size = size;
        coordinates = new int[size][2];
        placed = false;
        hits = 0;
        sunk = false;

    }

    public void placeShip(int firstX, int firstY, boolean northToSouth) {

        for (int i = 0; i < size; i++) {
            if (northToSouth) {
                coordinates[i][0] = firstX;
                coordinates[i][1] = firstY + i;
            } else {
                coordinates[i][0] = firstX + i;
                coordinates[i][1] = firstY;
            }
        }

        placed = true;
    }

    public boolean shipHit(int x, int y) {

        for (int i = 0; i < size; i++) {
            if (coordinates[i][0] == x && coordinates[i][1] == y) {
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

    public int[][] getCoordinates() {
        return coordinates;
    }

    public boolean isSunk() {
        return sunk;
    }

    public boolean isPlaced() {
        return placed;
    }
}
