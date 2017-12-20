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

        // Currently only placing size 2 ships
        // To replace with ability to choose placement
        int[][][] initPlaces = {
                {{1, 1}, {0, 0}, {3, 3}, {6, 8}, {1, 7}, {9, 2}, {9, 7}},
                {{1, 0}, {1, 2}, {9, 2}, {4, 6}, {5, 3}, {1, 9}, {3, 5}}
        };

        boolean[][] initOrientations = {
                {true, false, true, false, true, false, true},
                {false, true, false, true, false, true, false},
        };

        for (int i = 0; i < 2; i++) {
            Player player = new Player(gridSize);
            player.placeShips(initPlaces[i], initOrientations[i]);
            players.add(player);
            System.out.println(player.getShipGridString());
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
                int[] guess = commandParser.parseGuess(playerInput);
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

