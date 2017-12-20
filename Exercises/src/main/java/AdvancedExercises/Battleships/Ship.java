package AdvancedExercises.Battleships;

public class Ship {

    private String name;
    private int size;
    private int[][] coordinates;
    private boolean placed;
    private boolean sunk;

    public Ship(String name, int size) {

        this.name = name;
        this.size = size;
        coordinates = new int[size][2];
        placed = false;
        sunk = false;

    }

    public void placeShip(int firstX, int firstY, boolean northToSouth) {
        coordinates[0][0] = firstX;
        coordinates[0][1] = firstY;

        for (int i = 1; i < size; i++) {
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
