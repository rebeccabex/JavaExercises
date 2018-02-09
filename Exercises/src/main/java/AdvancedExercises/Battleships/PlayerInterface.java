package AdvancedExercises.Battleships;

public interface PlayerInterface {

    String playerInput(String prompt);
    String[] readShipPlacement(Ship ship);
    Coordinates getPlayerGuess(int playerNo);
    Coordinates convertCoordinates(String alphanumericCoords);
    String setOrientation(String inputOrientation);
    String actionText(GridSpace spaceAction);
    void displayAction(String output);
    String coordinateString(Coordinates coordinates);

}
