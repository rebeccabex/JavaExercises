package PairExercises;

import AdventureGame.CLInterface;

import java.util.ArrayList;
import java.util.Iterator;

public class Game {

    CLInterface cli;

    public Game() {
        cli = new CLInterface();
    }

    public void multiGame() {

        ArrayList<AI> aiList = new ArrayList<>();

        int[] playerUsed = {0, 0, 0};

        boolean playing = true;

        String input = cli.playerInput("Enter number of AI");

        try {
            int noOfAI = Integer.parseInt(input);

            for (int i = 0; i < noOfAI; i++) {
                aiList.add(new AI());
            }

            while (playing) {

                String playerChoice = cli.playerInput("Enter choice, or 'back' to return to menu:");

                if (playerChoice.equalsIgnoreCase("back")) {
                    playing = false;
                } else {

                    int[] choicesPlayed = {0, 0, 0};

                    choicesPlayed = updateChoiceArray(choicesPlayed, playerChoice);

                    for (AI ai : aiList) {
                        ai.setChoice(ai.generateMove(playerUsed));
                        choicesPlayed = updateChoiceArray(choicesPlayed, ai.getChoice());
                        System.out.println(ai.getChoice());
                    }

                    int chosen = 0;

                    for (int i = 0 ; i < 3; i++) {
                        if(choicesPlayed[i] > 0) {
                            chosen++;
                        }
                    }

                    if (chosen == 2) {
                        String winner = "";
                        String loser = "";

                        if (choicesPlayed[0] > 0) {
                            if (choicesPlayed[1] > 0) {
                                winner = "paper";
                                loser = "rock";
                            } else {
                                winner = "rock";
                                loser = "scissors";
                            }
                        } else {
                            winner = "scissors";
                            loser = "paper";
                        }

                        Iterator<AI> it = aiList.iterator();
                        while (it.hasNext()) {
                            AI ai = it.next();
                            if (ai.getChoice().equalsIgnoreCase(loser)) {
                                it.remove();
                            }
                        }

                        if (playerChoice.equalsIgnoreCase(loser)) {
                            System.out.println("Sorry, you lost");
                            playing = false;
                        } else if (aiList.size() == 0) {
                            System.out.println("Congratulations, you won!");
                            playing = false;
                        } else {
                            System.out.println("Well done, you made the next round");
                        }
                    } else {
                        System.out.println("Draw");
                    }
                }
            }
        } catch (NumberFormatException e) {
            System.out.println(input + " is not a number");
        }
    }


    public void aiVersusAI() {

        boolean playing = true;

        int ai1Score = 0;
        int ai2Score = 0;

        int[] ai1Used = {0, 0, 0};
        int[] ai2Used = {0, 0, 0};

        AI ai1 = new AI();
        AI ai2 = new AI();

        while (playing) {

            String playerInput = cli.playerInput("Enter number of games, or 'back' to return to menu");

            if (playerInput.equalsIgnoreCase("back")) {
                playing = false;
            } else {

                try {
                    int noOfGames = Integer.parseInt(playerInput);

                    for (int i = 0; i < noOfGames; i++) {

                        String ai1Choice = ai1.generateMove(ai2Used);
                        String ai2Choice = ai2.betterMove(ai2Used);

                        ai1Used = updateChoiceArray(ai1Used, ai1Choice);
                        ai2Used = updateChoiceArray(ai2Used, ai2Choice);

                        System.out.println(ai1Choice);
                        System.out.println(ai2Choice);

                        String winner = compareChoices(ai1Choice, ai2Choice);
                        if (winner.equalsIgnoreCase("player 1")) {
                            ai1Score++;
                        } else if (winner.equalsIgnoreCase("player 2")) {
                            ai2Score++;
                        }
                        System.out.println(winner + " Score: " + ai1Score + "-" + ai2Score);
                    }
                } catch (NumberFormatException e) {
                    System.out.println(playerInput + " is not a number");
                }
            }
        }
    }

    public void playerVersusAI() {

        int playerScore = 0;
        int aiScore = 0;

        AI ai = new AI();

        int[] playerUsed = {0, 0, 0};

        boolean playing = true;

        while (playing) {

            String playerChoice = cli.playerInput("Enter choice, or 'back' to return to menu:");

            String aiChoice = ai.generateMove(playerUsed);

            if (playerChoice.equalsIgnoreCase("back")) {
                playing = false;
            } else {
                playerUsed = updateChoiceArray(playerUsed, playerChoice);

                System.out.println(aiChoice);
                String winner = compareChoices(playerChoice, aiChoice);
                if (winner.equalsIgnoreCase("player 1")) {
                    playerScore++;
                } else if (winner.equalsIgnoreCase("player 2")) {
                    aiScore++;
                }
                System.out.println(winner + " Score: " + playerScore + "-" + aiScore);
            }
        }

    }

    public int[] updateChoiceArray(int[] choiceArray, String choice) {

        switch (choice.toLowerCase()) {
            case "rock":
                choiceArray[0]++;
                break;
            case "paper":
                choiceArray[1]++;
                break;
            case "scissors":
                choiceArray[2]++;
                break;
            default:
                System.out.println("Not a valid input");
        }

        return choiceArray;
    }


    public String compareChoices(String firstChoice, String secondChoice) {

        int playerChoiceValue = choiceValue(firstChoice);
        int aiChoiceValue = choiceValue(secondChoice);

        if (playerChoiceValue == aiChoiceValue) {
            return "Draw";
        } else if (playerChoiceValue + aiChoiceValue == 4) {
            if (playerChoiceValue == 1) {
                return "Player 1";
            } else {
                return "Player 2";
            }
        } else {
            if (playerChoiceValue > aiChoiceValue) {
                return "Player 1";
            } else {
                return "Player 2";
            }
        }

    }


    public int choiceValue(String choice) {
        switch (choice.toLowerCase()) {
            case "rock":
                return 1;
            case "paper":
                return 2;
            case "scissors":
                return 3;
            default:
                return 0;
        }
    }


}
