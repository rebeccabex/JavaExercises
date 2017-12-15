package AdventureGame;

import java.util.ArrayList;

public class Map {

    private int maxX;
    private int maxY;
    private Player player;
    private Item treasure;

    private int[][] grid;

    public Map(int x, int y) {

        maxX = x;
        maxY = y;

        grid = new int[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                grid[i][j] = 0;
            }
        }

        RandomGenerator rg = new RandomGenerator();
        int playerX = rg.getRandomInt(maxX);
        int playerY = rg.getRandomInt(maxY);

        placePlayerOnSquare(playerX, playerY);

        grid[playerX][playerY] = 1;

        int treasureX = 0;
        int treasureY = 0;

        do {
            treasureX = rg.getRandomInt(maxX);
            treasureY = rg.getRandomInt(maxY);
        } while (treasureX == playerX && treasureY == playerY);

        placeTreasureOnSquare(treasureX, treasureY);

        grid[treasureX][treasureY] = 2;

    }

    public void placeItemOnSquare(int x, int y, int itemVal) {
        grid[x][y] = itemVal;
    }

    public void placePlayerOnSquare(int x, int y) {
        placeItemOnSquare(x, y, 1);
        player = new Player(x, y);

    }

    public void placeTreasureOnSquare(int x, int y) {
        placeItemOnSquare(x, y, 2);
        treasure = new Item("Treasure", x, y);
    }

    public boolean foundTreasure(int x, int y) {
        return grid[x][y] == 2;
    }

    public int movePlayerNorth() {
        if (getPlayerY() < getMaxY()-1) {
            if(foundTreasure(getPlayerX(), getPlayerY() + 1)) {
                return 2;
            }
            grid[getPlayerX()][getPlayerY()+1] = 1;
            grid[getPlayerX()][getPlayerY()] = 0;
            player.moveNorth();
            return 1;
        } else {
            return 0;
        }
    }

    public int movePlayerSouth() {
        if (getPlayerY() > 0) {
            if(foundTreasure(getPlayerX(), getPlayerY() - 1)) {
                return 2;
            }
            grid[getPlayerX()][getPlayerY()-1] = 1;
            grid[getPlayerX()][getPlayerY()] = 0;
            player.moveSouth();
            return 1;
        } else {
            return 0;
        }
    }

    public int movePlayerEast() {
        if (getPlayerX() < getMaxX()-1) {
            if(foundTreasure(getPlayerX() + 1, getPlayerY())) {
                return 2;
            }
            grid[getPlayerX()+1][getPlayerY()] = 1;
            grid[getPlayerX()][getPlayerY()] = 0;
            player.moveEast();
            return 1;
        } else {
            return 0;
        }
    }

    public int movePlayerWest() {
        if (getPlayerX() > 0) {
            if(foundTreasure(getPlayerX() - 1, getPlayerY())) {
                return 2;
            }
            grid[getPlayerX()-1][getPlayerY()] = 1;
            grid[getPlayerX()][getPlayerY()] = 0;
            player.moveWest();
            return 1;
        } else {
            return 0;
        }
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

    public int distanceFromTreasure() {

        int xDist = Math.abs(getPlayerX() - getTreasureX());
        int yDist = Math.abs(getPlayerY() - getTreasureY());

        return (int) Math.sqrt(Math.pow(xDist, 2) + Math.pow(yDist, 2));

    }

    public int getMaxX() {
        return grid.length;
    }

    public int getMaxY() {
        return grid[0].length;
    }

    public int getSquareNo(int x, int y) {
        return x + y * maxX;
    }

}
