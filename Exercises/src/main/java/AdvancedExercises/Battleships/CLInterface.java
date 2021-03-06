package AdvancedExercises.Battleships;

import java.util.Scanner;

public class CLInterface implements PlayerInterface {

    private Scanner reader;

    public CLInterface() {
        reader = new Scanner(System.in);
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

    public Coordinates getPlayerGuess(int playerNo) {

        Coordinates guess = new Coordinates(-1, -1);
        String input = "";

        while (!guess.isValid()) {

            input = playerInput("Player " + playerNo + "'s turn." +
                    " Enter guess in form [letter][number] (eg A1) or enter 'QUIT' to exit:");

            if (input.length() == 2 || input.length() ==3) {
                guess = convertCoordinates(input);
            }
            if (!guess.isValid()) {
                System.out.println("Invalid input. Try again.");
            }

        }
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

    public Coordinates convertCoordinates(String alphanumericCoords) {

        Coordinates coordinates = new Coordinates(-1, -1);

        char letterPart = alphanumericCoords.toUpperCase().charAt(0);
        int numberPart = parseInt(alphanumericCoords.substring(1));
        if (letterPart >= 'A' && letterPart < 'M' && numberPart > 0 && numberPart <= 12) {
            coordinates.setX(letterPart - 'A');
            coordinates.setY(numberPart - 1);
        }

        return coordinates;
    }

    public String coordinateString(Coordinates coordinates) {
        char letter = (char) (coordinates.getX() + 'A');
        return Character.toString(letter) + (coordinates.getY() + 1);
    }

    public String actionText(GridSpace spaceAction) {

        String action;

        switch (spaceAction) {
            case EMPTY:
                action = "Missed!";
                break;
            case SHIP:
                action = "Hit! Have another turn!";
                break;
            case MISS:
                action = "You've already tried that space and it was empty. Guess again.";
                break;
            case HIT:
                action = "You've already tried that space and it was a hit. Guess again.";
                break;
            case SUNK:
                action = "You hit and sunk your opponent's ship! Have another turn!";
                break;
            case WON:
                action = "Congratulations! You sunk all of your opponent's ships! You win!";
                break;
            default:
                action = "Invalid coordinates.";
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

    public void displayAction(String output) {
        System.out.println(output);
    }
}
