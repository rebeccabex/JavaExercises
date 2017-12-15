package AdventureGame;

public class Square {

    private boolean playerOnSquare;
    private boolean itemOnSquare;
    private String description;

    public Square() {

        playerOnSquare = false;
        itemOnSquare = false;

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPlayerOnSquare() {
        return playerOnSquare;
    }

    public void setPlayerOnSquare(boolean playerOnSquare) {
        this.playerOnSquare = playerOnSquare;
    }

    public boolean isItemOnSquare() {
        return itemOnSquare;
    }

    public void setItemOnSquare(boolean itemOnSquare) {
        this.itemOnSquare = itemOnSquare;
    }
}
