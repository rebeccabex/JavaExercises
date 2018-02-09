package AdvancedExercises.Battleships;

public class Human extends Player {

    private PlayerInterface playerInterface;

    public Human(int playerNo, String name, int gridSize, PlayerInterface playerInterface) {
        super(playerNo, name, gridSize);
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
                Coordinates coordinates = playerInterface.convertCoordinates(playerInput[0]);
                String orientationString = playerInterface.setOrientation(playerInput[1]);

                if ("invalid".equalsIgnoreCase(orientationString)){
                    System.out.println("Invalid orientation. Must type H for horizontal or V for vertical.");
                } else {
                    boolean orientation = "v".equalsIgnoreCase(orientationString);
                    boolean placed = shipGrid.checkLocationAndPlaceShip(nextShipToPlace, coordinates, orientation);
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
    public Coordinates takeTurn() {

        boolean validGuess = false;
        Coordinates playerGuess = new Coordinates(-1, -1);

        while (!validGuess) {

            playerGuess = playerInterface.getPlayerGuess(playerNo);

            GridSpace spaceVal = targetGrid.targetCoordinates(playerGuess);

            if (spaceVal.equals(GridSpace.EMPTY)) {
                validGuess = true;
            } else {
                System.out.println(playerInterface.actionText(spaceVal));
            }
        }

        return playerGuess;
    }
}
