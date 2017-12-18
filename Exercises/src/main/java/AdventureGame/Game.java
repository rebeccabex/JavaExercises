package AdventureGame;

public class Game {

    private CLInterface cli;
    private CommandParser cp;

    public Game() {

        cli = new CLInterface();
        cp = new CommandParser();

        int mapSize = setMapSize();
        int noOfDecoys = setDecoyNumber();

        Settings settings = new Settings(mapSize, mapSize, noOfDecoys);

        Map map = new Map(settings);

        boolean playing = true;
        boolean playerWon = false;
        boolean playerQuit = false;

        // intro
        System.out.println("You find yourself in the middle of a misty swamp. " +
                "You can't see more than a metre in any direction. " +
                "You don't know why you are there, though you remember something about finding treasure. " +
                "There is a strange watch-like device on your wrist." +
                "\nYou can LOOK at the device, move NORTH, SOUTH, EAST, WEST. You can also request HELP or QUIT.");

        while (playing) {

            // provide description

            // prompt for input
            String command = cli.playerInput("Enter command:");

            // parse input
            String output = cp.parseInput(command, map);

            // update game
            if (output.toLowerCase().equals("quit")) {
                command = cli.playerInput("Are you sure you want to quit? Type y to confirm.");
                playerQuit = cp.checkQuit(command);
            } else if (output.toLowerCase().equals("treasure")) {
                playerWon = true;
            } else {
                System.out.println(output);
            }

            playing = ! (playerWon || playerQuit);

        }

        if (playerWon) {
            System.out.println("Congratulations! You found the treasure! " +
                    "Amongst its contents is a mysterious object that begins glowing. " +
                    "There's a flash of light and suddenly you are back at home!");
        } else {
            System.out.println("Sorry, you failed to find the treasure.");
        }

    }

    public static void main(String[] args) {

        Game game = new Game();

    }

    public int setMapSize() {

        int size = -1;

        while (size == -1) {
            String command = cli.playerInput("What size map you want? SMALL, MEDIUM, LARGE or CUSTOM");
            size = cp.parseGridSize(command);
            if (size == 0) {
                command = cli.playerInput("Enter grid size between 10 and 50 (inclusive):");
                size = cp.parseInt(command);
            }
        }

        return size;
    }

    public int setDecoyNumber() {

        int decoys = -1;

        while (decoys == -1) {
            String command = cli.playerInput("What level of difficulty you want? EASY, MEDIUM, HARD or CUSTOM");
            decoys = cp.parseDifficulty(command);
            if (decoys == -2) {
                command = cli.playerInput("Enter number of decoys between 0 and 10 (inclusive):");
                decoys = cp.parseInt(command);
            }
        }

        return decoys;
    }


}
