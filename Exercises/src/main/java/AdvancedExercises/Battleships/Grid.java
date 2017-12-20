package AdvancedExercises.Battleships;

public class Grid {

    private int size;
    // 0-empty sea; 1-part of ship; 2-miss; 3-hit
    private int[][] grid;

    public Grid(int size) {

        grid = new int[size][size];

        this.size = size;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = 0;
            }
        }

    }

    public boolean placeShip(Ship ship, int firstX, int firstY, boolean northToSouth) {

        boolean valid = true;

        if (northToSouth) {
            if (firstY + ship.getSize() > getSize()) {
                return false;
            }
        } else {
            if (firstX + ship.getSize() > getSize()) {
                return false;
            }
        }

        for (int i = 0; i < ship.getSize(); i++) {
            if (northToSouth) {
                if (grid[firstX][firstY + i] == 1) {
                    return false;
                }
            } else {
                if (grid[firstX + i][firstY] == 1) {
                    return false;
                }
            }
        }

        for (int i = 0; i < ship.getSize(); i++) {
            if (northToSouth) {
                grid[firstX][firstY + i] = 1;
            } else {
                grid[firstX + i][firstY] = 1;
            }
        }

        ship.placeShip(firstX, firstY, northToSouth);

        return valid;
    }

    public String gridToString() {

        String gridString = "";

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                gridString += grid[j][i];
            }
            gridString += "\n";
        }

        return gridString;
    }

    public int getSize() {
        return size;
    }
}