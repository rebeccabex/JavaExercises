package AdvancedExercises.Battleships;

import java.util.Scanner;

public class CLInterface implements PlayerInterface {

    private Scanner reader;
    private CommandParser commandParser;

    public CLInterface() {
        reader = new Scanner(System.in);
        commandParser = new CommandParser();
        setDelimiter("\n");
    }

    public String playerInput(String prompt) {

        System.out.println(prompt);

        return reader.next();

    }

    public String[] readShipPlacement(Ship ship) {

        String input = playerInput("Where do you want to place your next ship? (" +
                ship.getName() + ", Length: " + ship.getSize() + ")");

        return input.split(",");
    }

    public int[] getPlayerGuess(int playerNo) {

        String input = playerInput("Player " + playerNo + "'s turn." +
                " Enter guess in form [letter][number] (eg A1) or enter 'QUIT' to exit:");

        // validate input

        return convertCoordinates(input);
    }

    public String setOrientation(String inputOrientation) {

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

    public void setDelimiter(String delimiter) {
        reader.useDelimiter(delimiter);
    }

    public int[] convertCoordinates(String alphanumericCoords) {

        int[] coordinates = new int[2];

        coordinates[0] = alphanumericCoords.toUpperCase().charAt(0) - 'A';
        coordinates[1] = parseInt(alphanumericCoords.substring(1)) - 1;

        return coordinates;
    }

    public String actionText(int actionValue) {

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
                action = "Invalid coordinates.";
//                action = "Invalid coordinates. Must be between 0 and " + (gridSize - 1);
        }
        return action;
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