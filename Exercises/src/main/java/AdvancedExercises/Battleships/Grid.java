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

        // check input x and y are in grid
        if (!validCoordinates(firstX, firstY)) {
            return false;
        }

        // check entirety of ship is in grid
        if (northToSouth) {
            if (firstY + ship.getSize() > getSize()) {
                return false;
            }
        } else {
            if (firstX + ship.getSize() > getSize()) {
                return false;
            }
        }

        // check there is nothing already there where ship will be placed
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

        // place ship on grid
        for (int i = 0; i < ship.getSize(); i++) {
            if (northToSouth) {
                grid[firstX][firstY + i] = 1;
            } else {
                grid[firstX + i][firstY] = 1;
            }
        }

        // sets ship's coordinates
        ship.placeShip(firstX, firstY, northToSouth);

        return true;
    }

    public int targetCoordinates(int x, int y) {

        int spaceVal = -1;
        if (validCoordinates(x, y)) {
            spaceVal = grid[x][y];
        }
        return spaceVal;
    }

    public void updateGridSpace(int x, int y, boolean hit) {
        if (hit) {
            grid[x][y] = 3;
        } else {
            grid[x][y] = 2;
        }
    }

    public boolean validCoordinates(int x, int y) {

        if (x < 0 || x >= size) {
            return false;
        }

        if (y < 0 || y >= size) {
            return false;
        }
        return true;
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
