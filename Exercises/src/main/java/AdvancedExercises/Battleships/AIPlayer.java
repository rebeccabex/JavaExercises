package AdvancedExercises.Battleships;

import AdventureGame.RandomGenerator;
import java.util.ArrayList;
import java.util.Arrays;

public class AIPlayer extends Player {

    private RandomGenerator randGen = new RandomGenerator();
    private ArrayList<int[]> toSearch;
    private ArrayList<int[]> targetArea;
    private ArrayList<int[]> priorityTargetArea;
    private int[] lastHit;
    private int pause;

    public AIPlayer(int playerNo, String name, int gridSize, int pause) {
        super(playerNo, name, gridSize);
        toSearch = new ArrayList<>();
        targetArea = new ArrayList<>();
        priorityTargetArea = new ArrayList<>();
        lastHit = new int[] {-1, -1};
        this.pause = pause;
        initToSearch(gridSize);
    }

    public void initToSearch(int gridSize) {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j+=2 ) {
                int k = j + (i % 2);
                int[] temp = {i, k};
                toSearch.add(temp);
            }
        }
    }

    @Override
    public boolean setup() {

        Ship nextShipToPlace = nextShipToPlace();

        while (nextShipToPlace != null) {
            System.out.println(nextShipToPlace.getName());

            int xCoord = randGen.getRandomInt(shipGrid.getSize());
            int yCoord = randGen.getRandomInt(shipGrid.getSize());

            boolean orientation = randGen.getRandomInt(2) == 0;

            shipGrid.checkLocationAndPlaceShip(nextShipToPlace, xCoord, yCoord, orientation);

            nextShipToPlace = nextShipToPlace();
        }
        return true;
    }

    @Override
    public int[] takeTurn() {

        if (pause != 0) {
            try {
                Thread.sleep(pause);
            } catch (InterruptedException e) {
                System.out.println("Failed to sleep");
            }
        }
        int[] playerGuess = {-1, -1};

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

    private int[] randomGuess() {

        int randNum = randGen.getRandomInt(toSearch.size());
        int[] playerGuess = toSearch.get(randNum);
        toSearch.remove(randNum);

        return playerGuess;
    }

    private int[] targettedGuess(ArrayList<int[]> coordList) {

        boolean validGuess = false;
        int[] playerGuess = {-1, -1};

        while (!validGuess) {

            int randNum = randGen.getRandomInt(coordList.size());
            playerGuess = coordList.get(randNum);

            GridSpace spaceVal = targetGrid.targetCoordinates(playerGuess[0], playerGuess[1]);

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
    public void shotOutcome(int[] inputCoord, GridSpace outcome) {

        super.shotOutcome(inputCoord, outcome);

        if (!outcome.equals(GridSpace.EMPTY)) {
            lastHit = inputCoord;
            if (outcome.equals(GridSpace.SUNK)) {
                lastHit[0] = -1;
                lastHit[1] = -1;
                targetArea.addAll(priorityTargetArea);
                priorityTargetArea.clear();
            } else {
                setTargetArea(inputCoord);
                if (lastHit[0] != -1) {
                    setPriorityTargetArea(inputCoord);
                }
            }
        }
    }

    private void setPriorityTargetArea(int[] currentHit) {

        int[] temp = new int[2];
        int xDiff = currentHit[0] - lastHit[0];
        int yDiff = currentHit[1] - lastHit[1];

        if(xDiff == 0 && Math.abs(yDiff) == 1) {
            temp[0] = currentHit[0];
            temp[1] = currentHit[1] + yDiff;
            addToPriorityTargetArea(temp);
        } else if (yDiff == 0 && Math.abs(xDiff) == 1) {
            temp[0] = currentHit[0] + xDiff;
            temp[1] = currentHit[1];
            addToPriorityTargetArea(temp);
        }
    }

    private void addToPriorityTargetArea(int[] coords) {
        if (targetGrid.validCoordinates(coords[0], coords[1])) {
            priorityTargetArea.add(coords);
            removeFromArray(targetArea, coords);
            removeFromArray(toSearch, coords);
        }
    }

    private void setTargetArea(int[] target) {

        // currently adds all cells around hit space
        // even if already know which ship attacking
        // (ie, could carry on in straight line, but not currently capable)
        int[][] plusMinus = {{-1, 0} ,{1, 0} ,{0, -1} ,{0, 1}};

        for (int i = 0; i < 4; i++) {
			int[] tempArray = {target[0] + plusMinus[i][0], target[1] + plusMinus[i][1]};
			if (targetGrid.validCoordinates(tempArray[0], tempArray[1])) {
				if (targetGrid.targetCoordinates(tempArray[0], tempArray[1]).equals(GridSpace.INVALID)) {
				    if (!(targetArea.contains(tempArray) || priorityTargetArea.contains(tempArray))){
                        targetArea.add(tempArray);
                    }
                    removeFromArray(toSearch, tempArray);
				}
			}
        }
    }

    private void removeFromArray(ArrayList<int[]> searchList, int[] coords) {
        searchList.removeIf((int[] listCoords) -> Arrays.equals(listCoords, coords));
    }

    private void printSearchArrayLists() {
        System.out.println("toSearch (size " + toSearch.size() + ")");
        for (int[] a : toSearch) {
            System.out.println(a[0] + ", " + a[1]);
        }
        System.out.println("targetArea (size " + targetArea.size() + ")");
        for (int[] a : targetArea) {
            System.out.println(a[0] + ", " + a[1]);
        }
        System.out.println("priorityTargetArea (size " + priorityTargetArea.size() + ")");
        for (int[] a : priorityTargetArea) {
            System.out.println(a[0] + ", " + a[1]);
        }
    }
}
