package AdvancedExercises.Battleships;

import AdventureGame.CLInterface;

import java.util.ArrayList;

public class Battleships {

    private ArrayList<Player> players;
    private CLInterface clInterface;
    private CommandParser commandParser;
    private int gridSize;

    public Battleships() {

        clInterface = new CLInterface();
        commandParser = new CommandParser();
        clInterface.setDelimiter("\n");

        gridSize = 12;
        players = new ArrayList<>();

        setup();
        playGame();

    }

    public static void main(String[] args) {
        Battleships battleships = new Battleships();
    }

    public void setup() {

        for (int i = 0; i < 2; i++) {

            Player player = new Player(gridSize);

            System.out.println("Player " + (i+1) + "'s turn to place your ships" +
                    "\nType in format x coordinate, y coordinate, H(orizontal)/V(ertical)");

            Ship nextShipToPlace = player.nextShipToPlace();

            while (nextShipToPlace != null) {

                String playerInput = clInterface.playerInput("Where do you want to place your next ship? (" +
                        nextShipToPlace.getName() + ", Length: " + nextShipToPlace.getSize() + ")");

                // returns {x-coord, y-coord, orientation}
                String[] parsedInput = commandParser.parseShipPlacement(playerInput);

                if (parsedInput.length != 3) {
                    System.out.println("Invalid input. Try again");
                } else {
                    int[] coordinates = commandParser.parseCoordinates(parsedInput[0] + "," + parsedInput[1]);

                    String orientation = commandParser.parseOrientation(parsedInput[2]);
                    if (orientation.equalsIgnoreCase("invalid")){
                        System.out.println("Invalid orientation. Must type H for horizontal or V for vertical.");
                    }

                    boolean placed = player.placeShip(nextShipToPlace, coordinates, orientation);
                    if (!placed) {
                        System.out.println("Invalid ship placement");
                    }

                    nextShipToPlace = player.nextShipToPlace();
                }
                System.out.println(player.getShipGridString());
            }
            players.add(player);
        }
    }

    public void playGame() {

        boolean playing = true;

        int turnPlayer = 0;

        while (playing) {

            String playerInput = clInterface.playerInput("Player " + (turnPlayer + 1) + "'s turn." +
                    " Enter guess in form x, y or enter 'QUIT' to exit:");

            if (playerInput.equalsIgnoreCase("quit")) {
                playing = false;
            } else {
                int[] guess = commandParser.parseCoordinates(playerInput);
                int actionValue = players.get(flipPlayers(turnPlayer)).takeShot(guess);
                System.out.println(coordinateHitText(actionValue));

                // shows grid each turn for testing
                System.out.println(players.get(flipPlayers(turnPlayer)).getShipGridString());

                if (actionValue == 0) {
                    turnPlayer = flipPlayers(turnPlayer);
                } else {
                    if (actionValue == 5) {
                        playing = false;
                    }
                }
            }
        }
    }

    public String coordinateHitText(int actionValue) {

        String action = "";

        switch (actionValue) {
            case 0:
                action = "You missed";
                break;
            case 1:
                action = "You hit! Have another turn!";
                break;
            case 2:
                action = "You've already tried that space and it was empty. Guess again.";
                break;
            case 3:
                action = "You've already tried that space and it was a hit. Guess again.";
                break;
            case 4:
                action = "You hit and sunk your opponent's ship! Have another turn!";
                break;
            case 5:
                action = "Congratulations! You sunk all of your opponent's ships! You win!";
                break;
            default:
                action = "Invalid coordinates. Must be between 0 and " + (gridSize - 1);
        }
        return action;
    }


    // change 0 to 1 and vice versa
    public int flipPlayers(int i) {
        return -i + 1;
    }

}

