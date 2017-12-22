package AdvancedExercises.Battleships;

import java.util.ArrayList;

public class Battleships {

    private ArrayList<Player> players;
    private CommandParser commandParser;
    private PlayerInterface playerInterface;
    private int gridSize;

    public Battleships() {

        playerInterface = new CLInterface();

        gridSize = 12;
        players = new ArrayList<>();

        setup();
        playGame();

    }

    public static void main(String[] args) {
        Battleships battleships = new Battleships();
    }

    public void setup() {

        Player player = new AIPlayer(1, "AI 1", gridSize);
//        Player player = new Human(1, "Human", gridSize, playerInterface);

        player.setup();
        players.add(player);

        Player player2 = new AIPlayer(2, "AI 2", gridSize);

        player2.setup();
        players.add(player2);


    }

    public void playGame() {

        boolean playing = true;

        int turnPlayer = 0;

        while (playing) {

            playerInterface.displayAction("\n" + players.get(turnPlayer).getName() + "'s turn");
            int[] guess = players.get(turnPlayer).takeTurn();

            playerInterface.displayAction(playerInterface.coordinateString(guess));

            int actionValue = players.get(flipPlayers(turnPlayer)).opponentShot(guess);
            players.get(turnPlayer).shotOutcome(guess, actionValue);
            playerInterface.displayAction(playerInterface.actionText(actionValue));

            if (players.get(turnPlayer) instanceof Human) {
                playerInterface.displayAction(players.get(turnPlayer).getTargetGridString());
            } else {
                playerInterface.displayAction(players.get(flipPlayers(turnPlayer)).getShipGridString());
            }

            if (actionValue == 5) {
                playing = false;
            } else {
                if (actionValue == 0) {
                    turnPlayer = flipPlayers(turnPlayer);
                }
            }
        }
    }

    // change 0 to 1 and vice versa
    public int flipPlayers(int i) {
        return -i + 1;
    }
}

