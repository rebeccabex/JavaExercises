package AdventureGame;

public class Player {

    private int xCoordinate;
    private int yCoordinate;

    public Player(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public void moveNorth() {
        yCoordinate++;
    }

    public void moveSouth() {
        yCoordinate--;
    }

    public void moveEast() {
        xCoordinate++;
    }

    public void moveWest() {
        xCoordinate--;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }
}
