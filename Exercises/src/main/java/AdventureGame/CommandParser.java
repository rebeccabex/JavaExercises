package AdventureGame;

public class CommandParser {

    private String helpText = "Your goal is to find the treasure that is located somewhere in this swamp. " +
            "Your only guide is a strange watch-like device that tells you how close you are to another item. " +
            "Your possible actions are:" +
            "\n- LOOK - Check your distance device" +
            "\n- NORTH - Move north 1 metre" +
            "\n- SOUTH - Move south 1 metre" +
            "\n- EAST - Move east 1 metre" +
            "\n- WEST - Move west 1 metre" +
            "\n- HELP - bring up this help file" +
            "\n- QUIT - exit the game";

    public String parseInput(String command, Map map) {

        String text = "";
        boolean moved = false;
        boolean cannotMove = false;

        switch (command.toLowerCase()) {
            case "look":
                text = "You are " + map.distanceToClosestItem() + " metres from an item.";
                break;
            case "north":
            case "south":
            case "east":
            case "west":
                int val = parseMove(command, map);
                switch (val) {
                    case 0:
                        text = "You cannot move " + command + ". It is too boggy in this direction.";
                        break;
                    case 1:
                        text = "You moved 1 metre " + command;
                        break;
                    case 2:
                        text = "treasure";
                        break;
                    case 3:
                        text = "You found a chest! But it is empty. You must keep searching.";
                    default:
                        break;
                }
                break;
            case "help":
                text = helpText;
                break;
            case "quit":
                text = "quit";
                break;
            // CHEAT - TO BE REMOVED
            case "position":
                text = "x: " + map.getPlayerX() + "; y: " + map.getPlayerY();
                break;
            // CHEAT - TO BE REMOVED
            case "treasure":
                text = "x: " + map.getTreasureX() + "; y: " + map.getTreasureY();
                break;
            // CHEAT - TO BE REMOVED
            case "decoys":
                text = map.getDecoyListString();
                break;
            default:
                text = "Invalid command!";
                break;

        }

        return text;

    }

    public int parseMove(String command, Map map) {

        int val = 0;

        switch (command) {
            case "north":
                val = map.movePlayerNorth();
                break;
            case "south":
                val = map.movePlayerSouth();
                break;
            case "east":
                val = map.movePlayerEast();
                break;
            case "west":
                val = map.movePlayerWest();
                break;
        }

        return val;

    }

    public boolean checkQuit(String command) {
        return command.toLowerCase().equals("y") || command.toLowerCase().equals("yes");
    }

    public int parseGridSize(String command) {

        int size = 10;

        switch (command.toLowerCase()) {
            case "small":
                size = 10;
                break;
            case "medium":
                size = 15;
                break;
            case "large":
                size = 20;
                break;
            case "custom":
                size = 0;
                break;
            default:
                size = -1;
                break;
        }

        return size;
    }

    public int parseDifficulty(String command) {

        int decoy = 0;

        switch (command.toLowerCase()) {
            case "easy":
                decoy = 0;
                break;
            case "medium":
                decoy = 2;
                break;
            case "hard":
                decoy = 4;
                break;
            case "custom":
                decoy = -2;
                break;
            default:
                decoy = -1;
                break;
        }

        return decoy;
    }

    public int parseInt(String command) {
        try {
            int input = Integer.parseInt(command);
            return Math.max(Math.min(input, 50), 10);
        } catch (NumberFormatException e) {
            System.out.println(command + " is not a number");
            return -1;
        }
    }

}
