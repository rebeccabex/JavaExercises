package AdvancedExercises.Battleships;

public interface PlayerInterface {

    String playerInput(String prompt);
    String[] readShipPlacement(Ship ship);
    int[] getPlayerGuess(int playerNo);
    int[] convertCoordinates(String alphanumericCoords);
    String setOrientation(String inputOrientation);
    String actionText(int actionValue);

}
