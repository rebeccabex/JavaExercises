package AdventureGame;

import java.util.ArrayList;
import java.util.Iterator;

public class Map {

    private int maxX;
    private int maxY;
    private Player player;
    private Item treasure;
    private RandomGenerator rg;
    private ArrayList<Item> decoyList;

    private int[][] grid;

    public Map(Settings settings) {

        rg = new RandomGenerator();
        initialiseGrid(settings.getSizeX(), settings.getSizeY());
        initialisePlayer();
        initialiseItems(settings.getDecoyTreasures());

    }


    private void initialiseGrid(int x, int y) {

        maxX = x;
        maxY = y;

        grid = new int[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                grid[i][j] = 0;
            }
        }

    }

    private void initialisePlayer() {

        int playerX = rg.getRandomInt(maxX);
        int playerY = rg.getRandomInt(maxY);

        placePlayerOnSquare(playerX, playerY);

    }

    private void initialiseItems(int noOfDecoys) {

        decoyList = new ArrayList<Item>();

        int itemX = 0;
        int itemY = 0;

        do {
            itemX = rg.getRandomInt(maxX);
            itemY = rg.getRandomInt(maxY);
        } while (grid[itemX][itemY] != 0);

        placeTreasureOnSquare(itemX, itemY);

        for (int i = 0; i < noOfDecoys; i++) {
            do {
                itemX = rg.getRandomInt(maxX);
                itemY = rg.getRandomInt(maxY);
            } while (grid[itemX][itemY] != 0);

            placeDecoyOnSquare(itemX, itemY);
        }

    }

    private void placeItemOnSquare(int x, int y, int itemVal) {
        grid[x][y] = itemVal;
    }

    private void placePlayerOnSquare(int x, int y) {
        placeItemOnSquare(x, y, 1);
        player = new Player(x, y);

    }

    private void placeTreasureOnSquare(int x, int y) {
        placeItemOnSquare(x, y, 2);
        treasure = new Item("Treasure", x, y);
    }

    private void placeDecoyOnSquare(int x, int y) {
        placeItemOnSquare(x, y, 3);
        Item decoy = new Item("Decoy", x, y);
        decoyList.add(decoy);
    }

    public int foundItem(int x, int y) {
        return grid[x][y];
    }

    public boolean foundTreasure(int x, int y) {
        return grid[x][y] == 2;
    }

    public boolean foundDecoy(int x, int y) {
        return grid[x][y] == 3;
    }

    public int movePlayer(int deltaX, int deltaY) {

        int moveCode = 0;

        int item = foundItem(getPlayerX() + deltaX, getPlayerY() + deltaY);

        if (item > 1) {
            moveCode = item;
            if (item == 3) {
                removeFoundDecoy(getPlayerX() + deltaX, getPlayerY() + deltaY);
            }
        } else {
            moveCode = 1;
        }

        grid[getPlayerX() + deltaX][getPlayerY() + deltaY] = 1;
        grid[getPlayerX()][getPlayerY()] = 0;

        return moveCode;
    }

    public int movePlayerNorth() {

        int moveCode = 0;

        if (getPlayerY() < getMaxY()-1) {
            moveCode = movePlayer(0, 1);
            player.moveNorth();
        }

        return moveCode;
    }

    public int movePlayerSouth() {

        int moveCode = 0;

        if (getPlayerY() > 0) {
            moveCode = movePlayer(0, -1);
            player.moveSouth();
        }

        return moveCode;
    }

    public int movePlayerEast() {

        int moveCode = 0;

        if (getPlayerX() < getMaxX()-1) {
            moveCode = movePlayer(1, 0);
            player.moveEast();
        }

        return moveCode;
    }

    public int movePlayerWest() {

        int moveCode = 0;

        if (getPlayerX() > 0) {
            moveCode = movePlayer(-1, 0);
            player.moveWest();
        }

        return moveCode;
    }

    public int getSquare(int x, int y) {
        return grid[x][y];
    }

    public int getPlayerX() {
        return player.getxCoordinate();
    }

    public int getPlayerY() {
        return player.getyCoordinate();
    }

    public int getTreasureX() {
        return treasure.getxCoordinate();
    }

    public int getTreasureY() {
        return treasure.getyCoordinate();
    }

    public double distanceToClosestItem() {

        double min = distanceFromTreasure();

        for (Item i : decoyList) {
            int xDist = Math.abs(getPlayerX() - i.getxCoordinate());
            int yDist = Math.abs(getPlayerY() - i.getyCoordinate());

            double dist = Math.sqrt(Math.pow(xDist, 2) + Math.pow(yDist, 2));

            if(dist < min) {
                min = dist;
            }

        }

        return roundDouble(min, 1);
    }

    public double distanceFromTreasure() {

        int xDist = Math.abs(getPlayerX() - getTreasureX());
        int yDist = Math.abs(getPlayerY() - getTreasureY());

        return Math.sqrt(Math.pow(xDist, 2) + Math.pow(yDist, 2));

    }

    public double roundDouble(double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }

    public int getMaxX() {
        return grid.length;
    }

    public int getMaxY() {
        return grid[0].length;
    }

    public ArrayList<Item> getDecoyList() {
        return decoyList;
    }

    public String getDecoyListString() {
        String string = "";
        for (Item d : decoyList) {
            string += d.toString();
        }
        return string;
    }

    public void removeFoundDecoy(int x, int y) {

        Iterator<Item> it = decoyList.iterator();
        while (it.hasNext()) {
            Item d = it.next();
            if (d.getxCoordinate() == x && d.getyCoordinate() == y) {
                it.remove();
            }
        }
    }
}
