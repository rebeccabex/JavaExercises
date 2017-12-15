package AdventureGame;

public class Settings {

    private int sizeX;
    private int sizeY;
    private int decoyTreasures;

    public Settings(int sizeX, int sizeY, int decoyTreasures) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.decoyTreasures = decoyTreasures;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public int getDecoyTreasures() {
        return decoyTreasures;
    }

}
