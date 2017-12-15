package AdventureGame;

public class Game {

    public Game() {

        Map map = new Map(10, 10);

        CLInterface cli = new CLInterface();
        CommandParser cp = new CommandParser();

        boolean playing = true;
        boolean playerWon = false;
        boolean playerQuit = false;

        // intro
        System.out.println("You find yourself in the middle of a misty swamp. " +
                "You can't see more than a metre in any direction. " +
                "You don't know why you are there, though you remember something about finding treasure." +
                "\nYou can LOOK, move NORTH, SOUTH, EAST, WEST. You can also request HELP or QUIT.");

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


}
