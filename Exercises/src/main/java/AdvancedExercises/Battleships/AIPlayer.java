package AdvancedExercises.Battleships;

import AdventureGame.RandomGenerator;
import java.util.ArrayList;

public class AIPlayer extends Player {

    private RandomGenerator randGen = new RandomGenerator();
    private ArrayList<Coordinates> toSearch;
    private ArrayList<Coordinates> targetArea;
    private ArrayList<Coordinates> priorityTargetArea;
    private Coordinates lastHit;
    private int pause;

    public AIPlayer(int playerNo, String name, int gridSize, int pause) {
        super(playerNo, name, gridSize);
        toSearch = new ArrayList<>();
        targetArea = new ArrayList<>();
        priorityTargetArea = new ArrayList<>();
        lastHit = new Coordinates(-1, -1);
        this.pause = pause;
        initToSearch(gridSize);
    }

    public void initToSearch(int gridSize) {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j+=2 ) {
                int k = j + (i % 2);
                Coordinates temp = new Coordinates(i, k);
                toSearch.add(temp);
            }
        }
    }

    @Override
    public boolean setup() {

        Ship nextShipToPlace = nextShipToPlace();

        while (nextShipToPlace != null) {
            int xCoord = randGen.getRandomInt(shipGrid.getSize());
            int yCoord = randGen.getRandomInt(shipGrid.getSize());
            Coordinates coords = new Coordinates(xCoord, yCoord);

            boolean orientation = randGen.getRandomInt(2) == 0;

            shipGrid.checkLocationAndPlaceShip(nextShipToPlace, coords, orientation);

            nextShipToPlace = nextShipToPlace();
        }
        return true;
    }

    @Override
    public Coordinates takeTurn() {

        if (pause != 0) {
            try {
                Thread.sleep(pause);
            } catch (InterruptedException e) {
                System.out.println("Failed to sleep");
            }
        }
        Coordinates playerGuess = new Coordinates(-1, -1);

        try {
            if (priorityTargetArea.isEmpty()) {
                if (targetArea.isEmpty()) {
                    playerGuess = randomGuess();
                } else {
                    playerGuess = targettedGuess(targetArea);
                }
            } else {
                playerGuess = targettedGuess(priorityTargetArea);
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return playerGuess;
    }

    private Coordinates randomGuess() {

        int randNum = randGen.getRandomInt(toSearch.size());
        Coordinates playerGuess = toSearch.get(randNum);
        toSearch.remove(randNum);

        return playerGuess;
    }

    private Coordinates targettedGuess(ArrayList<Coordinates> coordList) {

        boolean validGuess = false;
        Coordinates playerGuess = new Coordinates(-1, -1);

        while (!validGuess) {

            int randNum = randGen.getRandomInt(coordList.size());
            playerGuess = coordList.get(randNum);

            GridSpace spaceVal = targetGrid.targetCoordinates(playerGuess);

            if (spaceVal.equals(GridSpace.EMPTY)) {
                validGuess = true;
            } else {
                if (coordList.isEmpty()) {
                    playerGuess = randomGuess();
                }
            }
            coordList.remove(randNum);
        }
        return playerGuess;
    }

    @Override
    public void shotOutcome(Coordinates inputCoord, GridSpace outcome) {

        super.shotOutcome(inputCoord, outcome);

        if (!outcome.equals(GridSpace.EMPTY)) {
            lastHit = inputCoord;
            if (outcome.equals(GridSpace.SUNK)) {
                lastHit.setToInvalid();
                targetArea.addAll(priorityTargetArea);
                priorityTargetArea.clear();
            } else {
                setTargetArea(inputCoord);
                if (!lastHit.isValid()) {
                    setPriorityTargetArea(inputCoord);
                }
            }
        }
    }

    private void setPriorityTargetArea(Coordinates currentHit) {

        Coordinates temp = new Coordinates(-1, -1);
        int xDiff = currentHit.getX() - lastHit.getX();
        int yDiff = currentHit.getY() - lastHit.getY();

        if(xDiff == 0 && Math.abs(yDiff) == 1) {
            temp = new Coordinates (currentHit.getX(), currentHit.getY() + yDiff);
        } else if (yDiff == 0 && Math.abs(xDiff) == 1) {
            temp = new Coordinates (currentHit.getX() + xDiff, currentHit.getY());
        }
        if (temp.isValid()) {
            addToPriorityTargetArea(temp);
        }
    }

    private void addToPriorityTargetArea(Coordinates coords) {
        if (targetGrid.validCoordinates(coords)) {
            priorityTargetArea.add(coords);
            removeFromArray(targetArea, coords);
            removeFromArray(toSearch, coords);
        }
    }

    private void setTargetArea(Coordinates target) {

        // currently adds all cells around hit space
        // even if already know which ship attacking
        // (ie, could carry on in straight line, but not currently capable)
        int[][] plusMinus = {{-1, 0} ,{1, 0} ,{0, -1} ,{0, 1}};

        for (int i = 0; i < 4; i++) {
            Coordinates tempCoords = new Coordinates(target.getX() + plusMinus[i][0], target.getY() + plusMinus[i][1]);
			if (targetGrid.validCoordinates(tempCoords)) {
				if (targetGrid.targetCoordinates(tempCoords).equals(GridSpace.INVALID)) {
				    if (!(targetArea.contains(tempCoords) || priorityTargetArea.contains(tempCoords))){
                        targetArea.add(tempCoords);
                    }
                    removeFromArray(toSearch, tempCoords);
				}
			}
        }
    }

    private void removeFromArray(ArrayList<Coordinates> searchList, Coordinates coords) {
        searchList.removeIf((Coordinates listCoords) -> listCoords.equals(coords));
    }

    private void printSearchArrayLists() {
        System.out.println("toSearch (size " + toSearch.size() + ")");
        for (Coordinates a : toSearch) {
            System.out.println(a.toString());
        }
        System.out.println("targetArea (size " + targetArea.size() + ")");
        for (Coordinates a : targetArea) {
            System.out.println(a.toString());
        }
        System.out.println("priorityTargetArea (size " + priorityTargetArea.size() + ")");
        for (Coordinates a : priorityTargetArea) {
            System.out.println(a.toString());
        }
    }
}
