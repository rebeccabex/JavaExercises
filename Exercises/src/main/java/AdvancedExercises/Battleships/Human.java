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
                String orientationString = playerInterface.setOrientation(playerInput[1]);

                if (orientationString.equalsIgnoreCase("invalid")){
                    System.out.println("Invalid orientation. Must type H for horizontal or V for vertical.");
                } else {
                    boolean orientation = orientationString.equalsIgnoreCase("v");
                    boolean placed = shipGrid.placeShip(nextShipToPlace, coordinates[0], coordinates[1], orientation);
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
    public void shotOutcome(int[] inputCoord, int outcome) {

        super.shotOutcome(inputCoord, outcome);
        System.out.println(playerInterface.actionText(outcome));
    }

    @Override
    public int opponentShot(int[] inputCoord) {

        int actionValue = super.opponentShot(inputCoord);
        System.out.println(playerInterface.actionText(actionValue));

        return actionValue;
    }
}
