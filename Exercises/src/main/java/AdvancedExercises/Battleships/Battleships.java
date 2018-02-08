package AdvancedExercises.Battleships;

import java.util.ArrayList;

public class Battleships {

    private ArrayList<Player> players;
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

        String gameType = playerInterface.playerInput("What game do you want to play?" +
                "\n1: Human vs Human" +
                "\n2: Human vs AI" +
                "\n3: AI vs AI");

        Player player1;
        Player player2;

        switch (gameType) {
            case "1":
                player1 = new Human(1, "Human", gridSize, playerInterface);
                player2 = new Human(2, "Human", gridSize, playerInterface);
                break;
            case "3":
                player1 = new AIPlayer(1, "AI 1", gridSize);
                player2 = new AIPlayer(2, "AI 2", gridSize);
                break;
            case "2":
            default:
                player1 = new Human(1, "Human", gridSize, playerInterface);
                player2 = new AIPlayer(2, "AI 1", gridSize);
        }

        player1.setup();
        players.add(player1);

        player2.setup();
        players.add(player2);
    }

    public void playGame() {

        boolean playing = true;

        int turnPlayer = 0;

        while (playing) {

            playerInterface.displayAction("\n" + players.get(turnPlayer).getName() + "'s turn");

            if (players.get(turnPlayer) instanceof Human) {
                playerInterface.displayAction(players.get(turnPlayer).getTargetGridString());
            }

            int[] guess = players.get(turnPlayer).takeTurn();

            playerInterface.displayAction(playerInterface.coordinateString(guess));

            GridSpace actionValue = players.get(flipPlayers(turnPlayer)).opponentShot(guess);
            players.get(turnPlayer).shotOutcome(guess, actionValue);
            playerInterface.displayAction(playerInterface.actionText(actionValue));

            if (players.get(turnPlayer) instanceof Human) {
                playerInterface.displayAction(players.get(turnPlayer).getTargetGridString());
            } else {
                playerInterface.displayAction(players.get(flipPlayers(turnPlayer)).getShipGridString());
            }

            if (actionValue.equals(GridSpace.WON)) {
                playing = false;
            } else {
                if (actionValue.equals(GridSpace.EMPTY)) {
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

