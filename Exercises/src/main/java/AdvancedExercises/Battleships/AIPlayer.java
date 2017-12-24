package AdvancedExercises.Battleships;

import AdventureGame.RandomGenerator;

import java.util.ArrayList;

public class AIPlayer extends Player {

    RandomGenerator randGen = new RandomGenerator();
    ArrayList<int[]> toSearch;
    ArrayList<int[]> targetArea;
    ArrayList<int[]> priorityTargetArea;
    int[] lastHit;

    public AIPlayer(int playerNo, String name, int gridSize) {
        super(playerNo, name, gridSize);
        toSearch = new ArrayList<>();
        targetArea = new ArrayList<>();
        priorityTargetArea = new ArrayList<>();
        lastHit = new int[] {-1, -1};
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

        System.out.println("AI is placing its ships");

        Ship nextShipToPlace = nextShipToPlace();

        while (nextShipToPlace != null) {

            int xCoord = randGen.getRandomInt(shipGrid.getSize());
            int yCoord = randGen.getRandomInt(shipGrid.getSize());

            boolean orientation;

            if (randGen.getRandomInt(2) == 0) {
                orientation = true;
            } else {
                orientation = false;
            }

            shipGrid.placeShip(nextShipToPlace, xCoord, yCoord, orientation);

            nextShipToPlace = nextShipToPlace();
        }
        return true;
    }

    @Override
    public int[] takeTurn() {

//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            System.out.println("Failed to sleep");
//        }

        int[] playerGuess;

        if (priorityTargetArea.isEmpty()) {
            if (targetArea.isEmpty()) {
                playerGuess = randomGuess();
            } else {
                playerGuess = targettedGuess(targetArea);
            }
        } else {
            playerGuess = targettedGuess(priorityTargetArea);
        }

        return playerGuess;
    }

    private int[] randomGuess() {

//        boolean validGuess = false;

        int randNum = randGen.getRandomInt(toSearch.size());
        int[] playerGuess = toSearch.get(randNum);
        toSearch.remove(randNum);

//        while (!validGuess) {
//            playerGuess[0] = randGen.getRandomInt(targetGrid.getSize() / 2) * 2;
//            playerGuess[1] = randGen.getRandomInt(targetGrid.getSize() / 2) * 2;
//
//            int spaceVal = targetGrid.targetCoordinates(playerGuess[0], playerGuess[1]);
//
//            if (spaceVal == 0) {
//                validGuess = true;
//            }
//        }
        return playerGuess;
    }

    private int[] targettedGuess(ArrayList<int[]> coordList) {

        boolean validGuess = false;
        int[] playerGuess = {-1, -1};

        while (!validGuess) {

            int randNum = randGen.getRandomInt(coordList.size());
            playerGuess = coordList.get(randNum);

            int spaceVal = targetGrid.targetCoordinates(playerGuess[0], playerGuess[1]);

            if (spaceVal == 0) {
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
    public void shotOutcome(int[] inputCoord, int outcome) {

        super.shotOutcome(inputCoord, outcome);

        if (outcome != 0) {
            if (lastHit[0] != -1) {
                setPriorityTargetArea(inputCoord);
            } else {
                setTargetArea(inputCoord);
            }
            lastHit = inputCoord;
//            if (outcome == 4) {
//                lastHit[0] = -1;
//                lastHit[1] = -1;
//                targetArea.clear();
//            }
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
            if (targetArea.contains(coords)) {
                targetArea.remove(coords);
            }
            if (toSearch.contains(coords)) {
                toSearch.remove(coords);
            }
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
				if (targetGrid.targetCoordinates(tempArray[0], tempArray[1]) == 0) {
				    if (!targetArea.contains(tempArray)){
                        targetArea.add(tempArray);
                    }
				}
			}
        }
    }
}
