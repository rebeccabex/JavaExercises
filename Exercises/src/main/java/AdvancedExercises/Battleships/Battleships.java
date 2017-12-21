package AdvancedExercises.Battleships;

import java.util.ArrayList;

public class Battleships {

    private ArrayList<Player> players;
    private CommandParser commandParser;
    private int gridSize;

    public Battleships() {

        commandParser = new CommandParser();

        gridSize = 12;
        players = new ArrayList<>();

        setup();
        playGame();

    }

    public static void main(String[] args) {
        Battleships battleships = new Battleships();
    }

    public void setup() {

        Player player = new Human(1, gridSize, new CLInterface());

        player.setup();
        players.add(player);

        Player player2 = new AIPlayer(2, gridSize);

        player2.setup();
        players.add(player2);


    }

    public void playGame() {

        boolean playing = true;

        int turnPlayer = 0;

        while (playing) {

            int[] guess = players.get(turnPlayer).takeTurn();
            int actionValue = players.get(flipPlayers(turnPlayer)).opponentShot(guess);
            players.get(turnPlayer).shotOutcome(guess, actionValue);

            System.out.println(players.get(turnPlayer).getTargetGridString());

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

