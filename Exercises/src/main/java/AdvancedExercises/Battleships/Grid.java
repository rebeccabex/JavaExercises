package AdvancedExercises.Battleships;

import java.util.List;

public class Grid {

    private int size;
    // 0-empty sea; 1-part of ship; 2-miss; 3-hit
    private GridSpace[][] gameGrid;

    public Grid(int size) {

        gameGrid = new GridSpace[size][size];

        this.size = size;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                gameGrid[i][j] = GridSpace.EMPTY;
            }
        }
    }

    public boolean checkLocationAndPlaceShip(Ship ship, int firstX, int firstY, boolean northToSouth) {

        if (shipFitsOnGrid(ship, firstX, firstY, northToSouth)) {
            return false;
        }

        if (!locationIsClear(ship, firstX, firstY, northToSouth)) {
            return false;
        }

        placeShip(ship, firstX, firstY, northToSouth);

        return true;
    }

    private boolean shipFitsOnGrid(Ship ship, int firstX, int firstY, boolean northToSouth) {
        if (!validCoordinates(firstX, firstY)) {
            return false;
        }

        if (northToSouth) {
            if (firstY + ship.getSize() > getSize()) {
                return false;
            }
        } else {
            if (firstX + ship.getSize() > getSize()) {
                return false;
            }
        }
        return true;
    }

    private boolean locationIsClear(Ship ship, int firstX, int firstY, boolean northToSouth) {
        for (int i = 0; i < ship.getSize(); i++) {
            if (northToSouth) {
                if (gameGrid[firstX][firstY + i].equals(GridSpace.SHIP)) {
                    return false;
                }
            } else {
                if (gameGrid[firstX + i][firstY].equals(GridSpace.SHIP)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void placeShip(Ship ship, int firstX, int firstY, boolean northToSouth) {
        for (int i = 0; i < ship.getSize(); i++) {
            if (northToSouth) {
                gameGrid[firstX][firstY + i] = (GridSpace.SHIP);
            } else {
                gameGrid[firstX + i][firstY] = (GridSpace.SHIP);
            }
        }
        ship.placeShip(firstX, firstY, northToSouth);
    }

    public GridSpace targetCoordinates(int x, int y) {

        GridSpace spaceVal = GridSpace.INVALID;
        if (validCoordinates(x, y)) {
            spaceVal = gameGrid[x][y];
        }
        return spaceVal;
    }

    public void updateGridSpace(int x, int y, boolean hit) {
        if (hit) {
            gameGrid[x][y] = GridSpace.HIT;
        } else {
            gameGrid[x][y] = GridSpace.MISS;
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
                gridString += gridCode(gameGrid[j][i]) + " ";
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


    public String gridCode(GridSpace spaceValue) {
        switch (spaceValue) {
            case EMPTY:
                return "~";
            case SHIP:
                return "S";
            case MISS:
                return "/";
            case HIT:
                return "X";
            default:
                return  "?";
        }
    }


    public int getSize() {
        return size;
    }
}
