package AdvancedExercises.Battleships;

import AdventureGame.RandomGenerator;

import java.util.ArrayList;

public class AIPlayer extends Player {

    RandomGenerator randGen = new RandomGenerator();
    int[] target;
    ArrayList<int[]> targetArea;

    public AIPlayer(int playerNo, String name, int gridSize) {
        super(playerNo, name, gridSize);
        target = resetTarget();
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

        if (target[0] == -1) {
            playerGuess = randomGuess();
        } else {
            playerGuess = targettedGuess();
        }

        return playerGuess;
    }

    private int[] randomGuess() {

        boolean validGuess = false;
        int[] playerGuess = {-1, -1};

        while (!validGuess) {
            playerGuess[0] = randGen.getRandomInt(targetGrid.getSize());
            playerGuess[1] = randGen.getRandomInt(targetGrid.getSize());

            int spaceVal = targetGrid.targetCoordinates(playerGuess[0], playerGuess[1]);

            if (spaceVal == 0) {
                validGuess = true;
            }
        }
        return playerGuess;
    }

    private int[] targettedGuess() {

        boolean validGuess = false;
        int[] playerGuess = {-1, -1};

        while (!validGuess) {

            int randNum = randGen.getRandomInt(targetArea.size());
            playerGuess = targetArea.get(randNum);

            int spaceVal = targetGrid.targetCoordinates(playerGuess[0], playerGuess[1]);

            if (spaceVal == 0) {
                validGuess = true;
            } else {
                targetArea.remove(randNum);
                if (targetArea.isEmpty()) {
                    playerGuess = randomGuess();
                    validGuess = true;
                    target = resetTarget();
                }
            }
        }
        return playerGuess;
    }

    @Override
    public void shotOutcome(int[] inputCoord, int outcome) {
        super.shotOutcome(inputCoord, outcome);
        if (outcome != 0) {
            target = inputCoord;
            setTargetArea(target);
        } else {
            target = resetTarget();
        }
    }

    private int[] resetTarget() {

        int[] blankArray = {-1, -1};

        for (int i = 0; i < 2; i++) {
            blankArray[i] = -1;
        }

        return blankArray;
    }

    // Need to correct targetArea
    private void setTargetArea(int[] target) {


        int[][] plusMinus = {{-1, 0} ,{1, 0} ,{0, -1} ,{0, 1}};


        for (int i = 0; i < 4; i++) {



//            int[] tempArray = {target[0], target[1]};
//            for (int j = 0; j < 2; j++) {
//                tempArray[j] = target[j] + plusMinus[i];
//                if (tempArray[0] >= 0 || tempArray[0] < targetGrid.getSize() || tempArray[1] >= 0 || tempArray[1] < targetGrid.getSize()) {
//                    targetArrayList.add(tempArray);
//                }
//            }
        }
    }
}
