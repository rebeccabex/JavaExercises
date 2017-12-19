package PairExercises;

import AdventureGame.RandomGenerator;

public class AI {

    private RandomGenerator rg;
    private int score;
    private String choice;

    public AI() {
        rg = new RandomGenerator();
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public String generateMove(int[] choiceArray) {

        int sum = 0;

        for (int i = 0; i < choiceArray.length; i++) {
            sum += choiceArray[i];
        }

        int randNum = rg.getRandomInt(sum + 3);

        if (randNum < choiceArray[0] + 1) {
            return "paper";
        } else if (randNum < choiceArray[0] + choiceArray[1] + 2) {
            return "scissors";
        } else {
            return "rock";
        }

    }
    public String betterMove(int[] choiceArray) {

        int sum = 0;

        for (int i = 0; i < choiceArray.length; i++) {
            sum += choiceArray[i];
        }

        int randNum = rg.getRandomInt(sum + 2);

        if (randNum <= choiceArray[0] + 1) {
            return "scissors";
        } else if (randNum <= choiceArray[0] + choiceArray[1] + 2) {
            return "rock";
        } else {
            return "paper";
        }

    }
}
