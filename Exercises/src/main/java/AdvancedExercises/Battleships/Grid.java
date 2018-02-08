package AdvancedExercises.Battleships;

import java.util.List;

public class Grid {

    private int size;
    // 0-empty sea; 1-part of ship; 2-miss; 3-hit
    private int[][] gameGrid;

    public Grid(int size) {

        gameGrid = new int[size][size];

        this.size = size;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                gameGrid[i][j] = 0;
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
                if (gameGrid[firstX][firstY + i] == 1) {
                    return false;
                }
            } else {
                if (gameGrid[firstX + i][firstY] == 1) {
                    return false;
                }
            }
        }

        // place ship on grid
        for (int i = 0; i < ship.getSize(); i++) {
            if (northToSouth) {
                gameGrid[firstX][firstY + i] = 1;
            } else {
                gameGrid[firstX + i][firstY] = 1;
            }
        }

        // sets ship's coordinates
        ship.placeShip(firstX, firstY, northToSouth);

        return true;
    }

    public int targetCoordinates(int x, int y) {

        int spaceVal = -1;
        if (validCoordinates(x, y)) {
            spaceVal = gameGrid[x][y];
        }
        return spaceVal;
    }

    public void updateGridSpace(int x, int y, boolean hit) {
        if (hit) {
            gameGrid[x][y] = 3;
        } else {
            gameGrid[x][y] = 2;
        }
    }

    public boolean validCoordinates(int x, int y) {

        if (x < 0 || x >= size) {
            return false;
        }

        return y >= 0 && y < size;
    }

    public boolean validCoordinates(List<Integer> coords) {
        return coords.size() == 2 && validCoordinates(coords.get(0), coords.get(1));
    }

    public String gridToString() {

        String[] gridCode = {"~", "S", "/", "X"};

        String gridString = "   ";

        for (char i = 'A'; i < size + 'A'; i++) {
            gridString += i + " ";
        }

        for (int i = 0; i < size; i++) {
            gridString += "\n" + (i + 1) + " ";
            if (i < 9) {
                gridString += " ";
            }
            for (int j = 0; j < size; j++) {
                gridString += gridCode[gameGrid[j][i]] + " ";
            }
            if (i < 9) {
                gridString += " ";
            }
            gridString += " " + (i + 1);
        }

        gridString += "\n   ";

        for (char i = 'A'; i < size + 'A'; i++) {
            gridString += i + " ";
        }

        return gridString;
    }

    public int getSize() {
        return size;
    }
}
