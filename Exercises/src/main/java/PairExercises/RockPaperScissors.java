package PairExercises;

import AdventureGame.CLInterface;
import com.sun.org.apache.bcel.internal.generic.RETURN;

public class RockPaperScissors {

    public RockPaperScissors() {

        Game game = new Game();

        CLInterface cli = new CLInterface();

        boolean playing = true;

        while (playing) {

            String playerInput = cli.playerInput("'Play' to play against AI, 'AI' to watch AI play AI, " +
                    "'multi' to play against multiple ai or 'end' to exit");

            switch (playerInput.toLowerCase()) {
                case "play":
                    game.playerVersusAI();
                    break;
                case "ai":
                    game.aiVersusAI();
                    break;
                case "multi":
                    game.multiGame();
                    break;
                case "end":
                    playing = false;
                    break;
                default:
                    System.out.println("Invalid input");
            }

        }

//


    }

    public static void main(String[] args) {

        RockPaperScissors rps = new RockPaperScissors();

    }

}
