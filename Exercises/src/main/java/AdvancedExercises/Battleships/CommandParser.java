package AdvancedExercises.Battleships;

public class CommandParser {

    public String[] parseShipPlacement(String placementString) {
        return placementString.split(",");
    }

    public int[] parseCoordinates(String guessString) {

        int[] guess = {-1, -1};

        String[] guessStringCoordinates = guessString.split(",");

        if (guessStringCoordinates.length == 2) {
            for (int i = 0; i < 2; i++) {
                guess[i] = parseInt(guessStringCoordinates[i].trim());
            }
        }
        return guess;
    }

    public int parseInt(String intString) {

        int value = -1;

        try {
            value = Integer.parseInt(intString);
        } catch (NumberFormatException e) {
            System.out.println(intString + " is not an integer");
        }
        return value;
    }
}
