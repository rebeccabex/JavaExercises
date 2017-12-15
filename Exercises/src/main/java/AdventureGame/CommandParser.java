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
                text = "You are " + map.distanceFromTreasure() + " metres from the treasure.";
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

}
