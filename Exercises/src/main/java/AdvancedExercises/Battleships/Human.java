package AdvancedExercises.Battleships;

public class Human extends Player {

    private PlayerInterface playerInterface;

    public Human(int playerNo, int gridSize, PlayerInterface playerInterface) {
        super(playerNo, gridSize);
        this.playerInterface = playerInterface;
    }

    @Override
    public boolean setup() {
        System.out.println("Player " + playerNo + "'s turn to place your ships" +
                "\nType in format [letter][number], [H(orizontal)/V(ertical)] (eg A1, H)");

        Ship nextShipToPlace = nextShipToPlace();

        while (nextShipToPlace != null) {

            String[] playerInput = playerInterface.readShipPlacement(nextShipToPlace);

            if (playerInput.length != 2) {
                System.out.println("Invalid input. Try again");
            } else {
                int[] coordinates = playerInterface.convertCoordinates(playerInput[0]);
                String orientation = playerInterface.setOrientation(playerInput[1]);

                if (orientation.equalsIgnoreCase("invalid")){
                    System.out.println("Invalid orientation. Must type H for horizontal or V for vertical.");
                } else {
                    boolean placed = placeShip(nextShipToPlace, coordinates, orientation);
                    if (!placed) {
                        System.out.println("Invalid ship placement");
                    }
                }

                nextShipToPlace = nextShipToPlace();
            }
            System.out.println(getShipGridString());
        }

        return false;
    }

    @Override
    public boolean placeShip(Ship shipToPlace, int[] inputCoord, String orientationLetter) {

        boolean orientation = orientationLetter.equalsIgnoreCase("v");

        return shipGrid.placeShip(shipToPlace, inputCoord[0], inputCoord[1], orientation);
    }

    @Override
    public int[] takeTurn() {

        boolean validGuess = false;
        int[] playerGuess = {-1, -1};

        while (!validGuess) {

            playerGuess = playerInterface.getPlayerGuess(playerNo);

            int spaceVal = targetGrid.targetCoordinates(playerGuess[0], playerGuess[1]);

            if (spaceVal == 0) {
                validGuess = true;
            } else {
                System.out.println(playerInterface.actionText(spaceVal));
            }
        }

        return playerGuess;
    }

    @Override
    public int opponentShot(int[] inputCoord) {

        int x = inputCoord[0];
        int y = inputCoord[1];

        int actionValue = shipGrid.targetCoordinates(x, y);

        if (actionValue == 0) {
            shipGrid.updateGridSpace(x, y, false);
        } else if (actionValue == 1) {
            shipGrid.updateGridSpace(x, y, true);
        }

        if (actionValue == 1) {
            Ship hitShip = shipSet.whichShipHit(x, y);
            if (shipSet.isShipSunk(hitShip)) {
                if (hasPlayerLost()) {
                    actionValue = 5;
                } else {
                    actionValue = 4;
                }
            }
        }
        System.out.println(playerInterface.actionText(actionValue));

        return actionValue;
    }

    @Override
    public int shotOutcome(int[] inputCoord, int outcome) {

        boolean hit = false;

        if (outcome != 0) {
            hit = true;
        }

        targetGrid.updateGridSpace(inputCoord[0], inputCoord[1], hit);

        return 0;
    }
}
