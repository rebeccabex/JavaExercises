package AdventureGame;

public class Item {

    private String itemName;
    private int xCoordinate;
    private int yCoordinate;

    public Item(String itemName, int xCoordinate, int yCoordinate) {
        this.itemName = itemName;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;

    }

    public String getItemName() {
        return itemName;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                ", xCoordinate=" + xCoordinate +
                ", yCoordinate=" + yCoordinate +
                '}';
    }
}
