package AdvancedExercises.Battleships;

public class CommandParser {

    public String[] parseShipPlacement(String placementString) {

        String[] stringArray = placementString.split(",");


        return stringArray;
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

    public String parseOrientation(String inputOrientation) {

        String orientation;

        switch (inputOrientation.toLowerCase().trim()) {
            case "h":
            case "horizontal":
                orientation = "h";
                break;
            case "v":
            case "vertical":
                orientation = "v";
                break;
            default:
                orientation = "invalid";
        }
        return orientation;
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
