package AdvancedExercises.Battleships;

import java.util.HashMap;

public class Grid {

    private int size;
    private HashMap<Coordinates, GridSpace> gameGrid;

    public Grid(int size) {

        gameGrid = new HashMap<>();

        this.size = size;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Coordinates coords = new Coordinates(i, j);
                gameGrid.put(coords, GridSpace.EMPTY);
            }
        }
    }

    public boolean checkLocationAndPlaceShip(Ship ship, Coordinates firstCoords, boolean northToSouth) {

        if (!shipFitsOnGrid(ship, firstCoords, northToSouth)) {
            return false;
        }

        if (!locationIsClear(ship, firstCoords, northToSouth)) {
            return false;
        }

        placeShip(ship, firstCoords, northToSouth);

        return true;
    }

    private boolean shipFitsOnGrid(Ship ship, Coordinates firstCoords, boolean northToSouth) {
        if (!validCoordinates(firstCoords)) {
            return false;
        }

        if (northToSouth) {
            if (firstCoords.getY() + ship.getSize() > getSize()) {
                return false;
            }
        } else {
            if (firstCoords.getX() + ship.getSize() > getSize()) {
                return false;
            }
        }
        return true;
    }

    private boolean locationIsClear(Ship ship, Coordinates firstCoords, boolean northToSouth) {
        for (int i = 0; i < ship.getSize(); i++) {
            Coordinates testCoords;
            if (northToSouth) {
                testCoords = new Coordinates(firstCoords.getX(), firstCoords.getY() + 1);
            } else {
                testCoords = new Coordinates(firstCoords.getX() + 1, firstCoords.getY());
            }
            if (gameGrid.get(testCoords).equals(GridSpace.SHIP)) {
                return false;
            }
        }
        return true;
    }

    private void placeShip(Ship ship, Coordinates firstCoords, boolean northToSouth) {
        for (int i = 0; i < ship.getSize(); i++) {
            Coordinates coordsToSet;
            if (northToSouth) {
                coordsToSet = new Coordinates(firstCoords.getX(), firstCoords.getY() + i);
            } else {
                coordsToSet = new Coordinates(firstCoords.getX() + i, firstCoords.getY());
            }
            gameGrid.put(coordsToSet, GridSpace.SHIP);
        }
        ship.placeShip(firstCoords, northToSouth);
    }

    public GridSpace targetCoordinates(Coordinates coords) {

        GridSpace spaceVal = GridSpace.INVALID;
        if (validCoordinates(coords)) {
            spaceVal = gameGrid.get(coords);
        }
        return spaceVal;
    }

    public void updateGridSpace(Coordinates coords, boolean hit) {
        if (hit) {
            gameGrid.put(coords, GridSpace.HIT);
        } else {
            gameGrid.put(coords, GridSpace.MISS);
        }
    }

    public boolean validCoordinates(Coordinates coords) {

        if (coords.getX() < 0 || coords.getX() >= size) {
            return false;
        }

        return coords.getY() >= 0 && coords.getY() < size;
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
                Coordinates coords = new Coordinates(j, i);
                gridString += gridCode(gameGrid.get(coords)) + " ";
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
