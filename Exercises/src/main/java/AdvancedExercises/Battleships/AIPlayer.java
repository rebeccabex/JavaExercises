package AdvancedExercises.Battleships;

import AdventureGame.RandomGenerator;

public class AIPlayer extends Player {

    RandomGenerator randGen = new RandomGenerator();

    public AIPlayer(int playerNo, String name, int gridSize) {
        super(playerNo, name, gridSize);
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

        boolean validGuess = false;
        int[] playerGuess = {-1, -1};

        while (!validGuess) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Failed to sleep");
            }

            playerGuess[0] = randGen.getRandomInt(targetGrid.getSize());
            playerGuess[1] = randGen.getRandomInt(targetGrid.getSize());

            int spaceVal = targetGrid.targetCoordinates(playerGuess[0], playerGuess[1]);

            if (spaceVal == 0) {
                validGuess = true;
            }
        }

        return playerGuess;
    }
}
